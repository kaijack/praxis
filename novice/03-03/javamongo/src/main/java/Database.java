package main.java;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

public class Database {
    private static MongoClient client;

    public static MongoClient getClient() {
        if (client == null) {
            client = MongoClients.create("mongodb://localhost");
        }
        return client;
    }
}