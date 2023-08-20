package com.example.week5day1.Controoler;

import com.example.week5day1.Api.ApiResponse;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Service.CustomerSecrvice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerSecrvice customersecrvice;

    @GetMapping("/")
    public ResponseEntity getCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customersecrvice.getCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer) {
        customersecrvice.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Customer Added"));
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity removeCustomer(@PathVariable Integer customerId) {
        customersecrvice.removeCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Customer deleted"));
    }
    @PutMapping("/update/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable Integer customerId,@RequestBody @Valid Customer customer) {
       customersecrvice.updateCustomer(customerId, customer);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Customer updated"));
    }

}