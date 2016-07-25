package com.example.stephen.housecall;

import android.content.Context;

import com.cloudant.sync.datastore.Datastore;
import com.cloudant.sync.datastore.DatastoreManager;
import com.cloudant.sync.datastore.DatastoreNotCreatedException;
import com.cloudant.sync.datastore.DocumentBodyFactory;
import com.cloudant.sync.datastore.DocumentException;
import com.cloudant.sync.datastore.DocumentRevision;
import com.cloudant.sync.replication.Replicator;
import com.cloudant.sync.replication.ReplicatorBuilder;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Stephen on 2016-07-24.
 */
public class PatientModel {

    private Datastore mDatastore;
    private final Context mContext;

    public PatientModel(Context context) {
        this.mContext = context;

        File path = this.mContext.getApplicationContext().getDir("datastores", Context.MODE_PRIVATE);
        DatastoreManager manager = DatastoreManagerSingleton.getInstance(path.getAbsolutePath());


        try {
            this.mDatastore = manager.openDatastore("patients");
        } catch(DatastoreNotCreatedException notCreatedException) {
            System.err.println("Problem opening datastore: "+notCreatedException);
        }
    }

    public Patient createDocument(Patient p){
        DocumentRevision rev = new DocumentRevision();
        rev.setBody(DocumentBodyFactory.create(p.asMap()));
        try {
            DocumentRevision created = this.mDatastore.createDocumentFromRevision(rev);
            return Patient.fromRevision(created);
        } catch (DocumentException de) {
            return null;
        }
    }

    public void pushReplication() throws URISyntaxException {
        URI uri = new URI("https://tonezelparramistingempla:c20538934354ad5fa9f8875f355797c1bc478045@92826306-0970-45ee-9fe1-aaf4416cf421-bluemix.cloudant.com/patients");

        Replicator replicator = ReplicatorBuilder.push().from(this.mDatastore).to(uri).build();
        replicator.start();

    }


}
