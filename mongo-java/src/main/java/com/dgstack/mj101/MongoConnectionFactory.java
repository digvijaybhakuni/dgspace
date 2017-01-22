package com.dgstack.mj101;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by digvijayb on 22/01/17.
 */
public class MongoConnectionFactory {


    static Map<String, MongoDatabase> dbMap = new HashMap<String, MongoDatabase>(10, 1);

    static MongoClient mongoClient = new MongoClient();

    public static MongoClient mongoClient(){
        return mongoClient;
    }

    public static MongoDatabase mongoDatabase(String db){
        MongoDatabase mongoDatabase = dbMap.get(db);
        if (mongoDatabase == null) {
            mongoDatabase = mongoClient().getDatabase(db);
            dbMap.put(db, mongoDatabase);
        }
        return mongoDatabase;
    }

}
