package com.dgstack.mj101.week2;

import com.dgstack.mj101.MongoConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Sorts.orderBy;

/**
 * Created by digvijayb on 22/01/17.
 */
public class RemoveLowScoreHomework {


    public static void main(String... args){
        final MongoDatabase db = MongoConnectionFactory.mongoDatabase("students");

        MongoCollection<Document> grades = db.getCollection("grades");
        final Document filter = new Document("type", "homework");

        Bson sort = ascending("student_id", "score");

        System.out.println(sort);

        List<Document> list = grades.find(filter).sort(sort).into(new ArrayList<Document>());

        Document tempDoc = null;

        Iterator<Document> iterator = list.iterator();
        int i = 0;

        while (iterator.hasNext()){

            Document doc = iterator.next();
            if(tempDoc != null){

                if (!doc.getInteger("student_id").equals(tempDoc.getInteger("student_id"))) {
                    //grades.deleteOne(doc);
                    i++;
                }

            }else{
                i++;
                //grades.deleteOne(doc);

            }

            tempDoc = doc;

        }

        System.out.println(i+" deleted ");

/*        list.stream().filter(e ->{
                try {
                    return tempDoc != null && !e.get("student_id").equals(tempDoc.get("student_id"));
                }finally {
                    tempDoc = e;
                }

        });*/

    }

}
