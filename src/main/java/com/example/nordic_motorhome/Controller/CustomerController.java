package com.example.nordic_motorhome.Controller;

import com.example.nordic_motorhome.Models.Customer;
import com.example.nordic_motorhome.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//Mohammad (Benjamin support)
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Gets all customers from the database
    @GetMapping("/customerindex")
    public String customerindex (Model model){
        model.addAttribute("customers", customerService.fetchAllItems());
        return "customerindex";
    }

    //Returns the createCustomer.html page
    @GetMapping("/createCustomer")
    public String showCreatePageCustomer(){
        return "createCustomer";
    }

    //Posting the data inserted into the database and redirect to customerIndex.html
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/customerindex";
    }

    //Delete a customer by id - Redirects to the same page because we justh ave a popup asking to confirm
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customerindex";
    }

    // Getting the update html page with the unique ID of the customer to autofill the form
    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute( "customer", customerService.findById(id));
        return "updateCustomer";
    }

    // Saves to database and redirect back CustomerIndex 
    @PostMapping("/updateCustomer")
    public String updateCustomerNow(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customerindex";
    }
}
