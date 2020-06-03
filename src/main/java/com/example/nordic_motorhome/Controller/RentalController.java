package com.example.nordic_motorhome.Controller;

import com.example.nordic_motorhome.Models.Car;
import com.example.nordic_motorhome.Models.Order;
import com.example.nordic_motorhome.Repository.OrderRepo;
import com.example.nordic_motorhome.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//Frederik
@Controller
public class RentalController {

    // Creating an object of OrderService called service
    @Autowired
    OrderService service;

    // Get all rental from the database and display it to the Tabel
    @GetMapping("/rental")
    public String rental(Model model){
        model.addAttribute("orders", service.fecthAllItems());
        return "rental";
    }

    // Showing the Create_rental page
    @GetMapping("/create_rental")
    public String create_rental(){
        return "create_rental";
    }

    // Saving the form to the database with all the inserted data
    @PostMapping("create_rental")
    public String create_rental(@ModelAttribute Order order)
    {
        service.addOrder(order);
        return "redirect:/rental";
    }

    // Delete a rental by its id - It's a popup the user will therefor be redirected to rental page
    @GetMapping("/delete_rental/{id}")
    public String delete_rental(@PathVariable("id") int id){
        service.deleteOrder(id);
        return "redirect:/rental";
    }

    // Loading the update page and the data from the database
    @GetMapping("/update_rental/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute( "order", service.findByID(id));
        return "update_rental";
    }

    // Saving the changed data back to the database and redirect to rental.html
    @PostMapping("/update_rental")
    public String updateNow(@ModelAttribute Order order){
        service.updateOrder(order);
        return "redirect:/rental";
    }
}
