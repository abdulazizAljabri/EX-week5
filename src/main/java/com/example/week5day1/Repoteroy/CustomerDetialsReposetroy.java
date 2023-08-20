package com.example.week5day1.Repoteroy;

import com.example.week5day1.Model.CustomerDetials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetialsReposetroy extends JpaRepository<CustomerDetials,Integer> {
    CustomerDetials findCustomerDetialsById(Integer id);
}
