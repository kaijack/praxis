/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanmongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author PPTIK
 */
public class LatihanMongoDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MongoException {
        try {
            // TODO code application logic here
            Mongo mongo = new Mongo();
            
            //select database akademik
            DB db = mongo.getDB("akademik");
            //select tabel mahasiswa
            DBCollection collection = db.getCollection("mahasiswa");
            
            //insert data
            BasicDBObject object = new BasicDBObject();
            object.put("nim", "5301405005");
            object.put("nama", "Luthfi Emka");
            
            object.put("nim", "5301405006");
            object.put("nama", "Emka");

            collection.insert(object);
            
            //select dan tampilkan data yang ada
            ArrayList list = new ArrayList();
 
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
               DBObject object_cursor = cursor.next();
               list.add(object_cursor);
            }
            


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
