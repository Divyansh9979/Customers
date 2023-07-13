package com.example.Customers.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customers")
@Data
public class Customers {

    private String username;
    private String name;
    private String address;
    private String birthDate;
    private String email;
    private boolean active;
    private List<Long> accounts;
    private TierDetails tier_and_details;

}
