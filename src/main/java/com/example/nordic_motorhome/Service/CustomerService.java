package com.example.nordic_motorhome.Service;


import com.example.nordic_motorhome.Models.Car;
import com.example.nordic_motorhome.Models.Customer;
import com.example.nordic_motorhome.Repository.CarRepo;
import com.example.nordic_motorhome.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Mohammad (Benjamin support)
@Service
public class CustomerService
{
    // Creating a new object called customerRepo
    @Autowired
    CustomerRepo customerRepo;

    // Service methods where we would clean up the data if needed - Pattern pure fabrication
    public List<Customer> fetchAllItems(){
        return customerRepo.fetchAllItems();
    }

    public void addCustomer(Customer c){

        customerRepo.addCustomer(c);
    }
    public void deleteCustomer(int id){
        customerRepo.deleteCustomer(id);
    }

    public void updateCustomer(Customer c){
        customerRepo.updateCustomer(c);
    }

    public Customer findById(int id){
        return customerRepo.findById(id);
    }






}
