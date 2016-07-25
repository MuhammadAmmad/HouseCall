package com.example.stephen.housecall;

import com.cloudant.sync.datastore.DatastoreManager;

/**
 * Created by Stephen on 2016-07-24.
 */
public class DatastoreManagerSingleton {
    private static DatastoreManager instance;

    public static DatastoreManager getInstance(String path) {
        if(instance == null) {
            instance = new DatastoreManager(path);
        }
        return instance;
    }
}
