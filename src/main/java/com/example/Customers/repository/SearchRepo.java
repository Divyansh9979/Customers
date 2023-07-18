package com.example.Customers.repository;

import com.example.Customers.model.Customers;

import java.util.List;

public interface SearchRepo {
    List<Customers> findCustomersByString(String text);
}
