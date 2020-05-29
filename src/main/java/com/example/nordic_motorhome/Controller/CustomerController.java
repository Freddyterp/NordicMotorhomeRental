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

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customerindex")
    public String customerindex (Model model){
        model.addAttribute("customers", customerService.fetchAllItems());
        return "customerindex";
    }

    @GetMapping("/createCustomer")
    public String showCreatePageCustomer(){
        return "createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/customerindex";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customerindex";
    }

    @GetMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute( "customer", customerService.findById(id));
        return "updateCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomerNow(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customerindex";
    }
}
