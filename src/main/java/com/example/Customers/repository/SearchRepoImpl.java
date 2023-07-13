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
    public List<Customers> findCustomersByText(String text) {
        final List<Customers> customers = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("sample_analytics");
        MongoCollection<Document> collection = database.getCollection("customers");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("index", "text")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("username", "name")))),
                new Document("$sort",
                        new Document("active", 1L)),
                new Document("$limit", 10L)));

        result.forEach(doc -> customers.add(mongoConverter.read(Customers.class, doc)));

        return customers;
    }
}
