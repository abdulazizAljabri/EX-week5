package com.example.week5day1.Service;

import com.example.week5day1.Api.ApiException;
import com.example.week5day1.DTO.DetailsDTO;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Model.CustomerDetials;
import com.example.week5day1.Repoteroy.CustomerDetialsReposetroy;
import com.example.week5day1.Repoteroy.CustomerReposetroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetialsService {
    private final CustomerDetialsReposetroy customerdetialsreposetroy;
    private final CustomerReposetroy customerrepoervice;


    public List<CustomerDetials> getAll(){
        return customerdetialsreposetroy.findAll();
    }
    public void addDetails(DetailsDTO detailsDTO) {
        Customer customer = customerrepoervice.findCustomerById(detailsDTO.getCustomer_id());
        if(customer == null) {
            throw new ApiException("Customer not found");
        }
        CustomerDetials customerDetials = new CustomerDetials(null,detailsDTO.getGender(),detailsDTO.getAge(),detailsDTO.getEmail(),customer);
        customerdetialsreposetroy.save(customerDetials);
    }

    public void removeDetails(Integer id) {
        Customer customer = customerrepoervice.findCustomerById(id);
        if(customer == null){
            throw new ApiException("Customer not found");
        }
       CustomerDetials customerDetials = customerdetialsreposetroy.findCustomerDetialsById(id);
        customerdetialsreposetroy.delete(customerDetials);
    }

    public void updateDetails(DetailsDTO detailsDTO){

        CustomerDetials customerDetials = customerdetialsreposetroy.findCustomerDetialsById(detailsDTO.getCustomer_id());
        customerDetials.setGender(detailsDTO.getGender());
        customerDetials.setAge(detailsDTO.getAge());
        customerDetials.setEmail(detailsDTO.getEmail());
        customerdetialsreposetroy.save(customerDetials);

    }
//    public void updateDetails( Integer customerId,DetailsDTO detailsDTO){
//        Customer customer1 = customerrepoervice.findCustomerById(detailsDTO.getCustomer_id());
//        if(customer1 == null){
//            throw new ApiException("Customer not found");
//        }
//        customer1.setName(customer1.getName());
//        customerreposetroy.save(customer1);
//    }

}
