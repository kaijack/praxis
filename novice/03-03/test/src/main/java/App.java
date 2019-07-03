import com.mongodb.Block;
import com.mongodb.client.mongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

public class App {
    public static void main(String[] args) {
        MongoDatabase db = Database.getClient().getDatabase("java");

        App app = new App();

        app.getUsers(db.getCollection("users"), new Block<DOcuments>() {
            @Override
            public void apply(final Document doc) {
                System.out.println(doc.toJson());
            }
        });
    }

    void createCollection(MongoDatabase db, String name) {
        try {
            db.createCollection(name);
        } catch (Exception e) {
        }
    }

    void createUsers(MongoCollection<Document> collection, String[] username) {
        for (String un : username) {
            Document document = new Document("username", un);
            collection.insertOne(document);
        }
    }
}