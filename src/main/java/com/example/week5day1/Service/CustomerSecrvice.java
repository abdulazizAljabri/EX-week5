package com.example.week5day1.Service;

import com.example.week5day1.Api.ApiException;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Repoteroy.CustomerDetialsReposetroy;
import com.example.week5day1.Repoteroy.CustomerReposetroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerSecrvice {
    private final CustomerReposetroy customerreposetroy;
    private final CustomerDetialsReposetroy customerdetialsreposetroy;

    public List<Customer> getCustomers(){
        return customerreposetroy.findAll();
    }

    public void addCustomer(Customer customer){
        customerreposetroy.save(customer);
    }

    public void updateCustomer( Integer customerId,Customer customer){
        Customer customer1 = customerreposetroy.findCustomerById(customerId);
        if(customer1 == null){
            throw new ApiException("Customer not found");
        }
        customer1.setName(customer1.getName());
        customerreposetroy.save(customer1);
    }

    public void removeCustomer(Integer customerId){
        Customer customer = customerreposetroy.findCustomerById(customerId);
        if(customer == null){
            throw new ApiException("Customer not found");
        }
        customerdetialsreposetroy.deleteById(customerId);
        customerreposetroy.delete(customer);
    }

//    public void addDetials(Integer customerId){
//
//    }



}
