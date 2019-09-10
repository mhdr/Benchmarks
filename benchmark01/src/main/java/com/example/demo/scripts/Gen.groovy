package com.example.demo.scripts

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document

MongoClient mongoClient = new MongoClient("localhost", 27017);
MongoDatabase database = mongoClient.getDatabase("mydb");
MongoCollection<Document> collection = database.getCollection("users");

List<Document> docs = new ArrayList<>()
int i
for (i = 0; i < 1000; i++) {
    Document doc = new Document("name", "guest")
            .append("coins", 0)
            .append("emojis", Arrays.asList(22, 12))
            .append("createdAt", new Date())

    docs.add(doc)
}

collection.insertMany(docs)
mongoClient.close()