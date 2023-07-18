package com.example.Customers.controller;

import com.example.Customers.model.Customers;
import com.example.Customers.repository.CustomersRepo;
import com.example.Customers.repository.SearchRepo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class CustomersController {

    private final CustomersRepo customersRepo;

    private final SearchRepo searchRepo;

    @Autowired
    private CustomersController(CustomersRepo customersRepo, SearchRepo searchRepo) {
        this.customersRepo = customersRepo;
        this.searchRepo = searchRepo;
    }

    @RequestMapping("/")
    public void redirectToSwagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/getAllCustomers")
    public List<Customers> getAllCustomers() {
        try {
            List<Customers> customers = customersRepo.findAll();
            log.info("Total Customers: {}",customers.size());
            return customers;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Error while getting all customers: {}",e.getMessage());
            throw new RuntimeException("Failed to retrieve customers!");
        }
    }

    @GetMapping("/getCustomers/{text}")
    public List<Customers> getCustomers(@PathVariable String text) throws Exception {
        try {
            List<Customers> customers = searchRepo.findCustomersByString(text);
            if(customers.isEmpty()) {
                throw new Exception("No Customer Found!");
            }
            log.info("Customers Found Successfully! Search Text: {}",text);
            return customers;
        } catch (Exception e) {
            log.error("No Customer Found with text: {}",text);
            e.printStackTrace();
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    @PostMapping("/postCustomers")
    public Customers postCustomers(@RequestBody Customers customers) {
        return customersRepo.save(customers);
    }

}
