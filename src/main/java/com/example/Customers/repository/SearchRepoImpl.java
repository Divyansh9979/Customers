package com.example.Customers.repository;

import com.example.Customers.model.Customers;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Customers> findCustomersByString(String text) {
        final List<Customers> customers = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("first_project");
        MongoCollection<Document> collection = database.getCollection("customers");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("name","username")))),
                new Document("$sort",
                        new Document("username", 1L)),
                new Document("$limit", 10L)));

        result.forEach(doc -> customers.add(mongoConverter.read(Customers.class, doc)));

        return customers;
    }
}
