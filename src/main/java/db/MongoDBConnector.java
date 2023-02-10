package db;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class MongoDBConnector {
    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<Document> collection;

    public static void connectToDatabase(){
        client = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    }

    public static void setCollection(String collection, MongoDatabase connectedDatabase){
        database = connectedDatabase;
        database.createCollection(collection);
    }

    public static MongoDatabase getDatabase(String database) {
        return client.getDatabase(database);
    }

    public static MongoCollection getCollection(String collection){
        return database.getCollection(collection);
    }



    private static void displayCollectionData() {
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
