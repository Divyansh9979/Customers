package com.example.Customers.model;

import lombok.Data;

import java.util.List;

@Data
public class TierDetails {

    private String id;
    private String tier;
    private boolean active;
    private List<String> benefits;

}
