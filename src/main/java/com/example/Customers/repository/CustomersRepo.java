package com.example.Customers.repository;

import com.example.Customers.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomersRepo extends MongoRepository<Customers,String> {
}
