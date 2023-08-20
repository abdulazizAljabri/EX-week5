package com.example.week5day1.Repoteroy;

import com.example.week5day1.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReposetroy extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);
}
