package com.example.stephen.housecall;

import android.content.Context;

import com.cloudant.sync.datastore.ConflictException;
import com.cloudant.sync.datastore.Datastore;
import com.cloudant.sync.datastore.DatastoreManager;
import com.cloudant.sync.datastore.DatastoreNotCreatedException;
import com.cloudant.sync.datastore.DocumentBodyFactory;
import com.cloudant.sync.datastore.DocumentException;
import com.cloudant.sync.datastore.DocumentRevision;
import com.cloudant.sync.query.IndexManager;
import com.cloudant.sync.query.QueryResult;
import com.cloudant.sync.replication.Replicator;
import com.cloudant.sync.replication.ReplicatorBuilder;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stephen on 2016-07-24.
 */
public class PatientModel {

    private Datastore mDatastore;
    private final Context mContext;
    private IndexManager indexManager;

    public PatientModel(Context context) {
        this.mContext = context;

        File path = this.mContext.getApplicationContext().getDir("datastores", Context.MODE_PRIVATE);
        DatastoreManager manager = DatastoreManagerSingleton.getInstance(path.getAbsolutePath());


        try {
            this.mDatastore = manager.openDatastore("patients");
            indexManager = new IndexManager(mDatastore);
        } catch(DatastoreNotCreatedException notCreatedException) {
            System.err.println("Problem opening datastore: "+notCreatedException);
        }
    }

    public void findDocument() throws ConflictException {
        Map<String, Object> query = new HashMap<String, Object>();
        /*
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("$search", "\"user\"");
        query.put("$text", search);
        */
        query.put("doc", "7");

        QueryResult result = indexManager.find(query);

        if (result.size() != 1){
            System.err.print("query id is not unique");
            return;
            //return null;
        }


        if(result == null){
            System.out.println("not found");
            return;
        }

        for (DocumentRevision rev : result) {
           //return  Patient.fromRevision(rev);
            System.out.println(rev);
        }
        //System.err.print("did not find patient");
    //return null;

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
