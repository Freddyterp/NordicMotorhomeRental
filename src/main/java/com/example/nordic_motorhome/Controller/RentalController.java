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

    @Autowired
    OrderService service;

    @GetMapping("/rental")
    public String rental(Model model){
        model.addAttribute("orders", service.fecthAllItems());
        return "rental";
    }

    @GetMapping("/create_rental")
    public String create_rental(){
        return "create_rental";
    }

    @PostMapping("create_rental")
    public String create_rental(@ModelAttribute Order order)
    {
        service.addOrder(order);
        System.out.println("Debug");
        return "redirect:/rental";
    }

    @GetMapping("/delete_rental/{id}")
    public String delete_rental(@PathVariable("id") int id){
        service.deleteOrder(id);
        return "redirect:/rental";
    }

    @GetMapping("/update_rental/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute( "order", service.findByID(id));
        return "update_rental";
    }

    @PostMapping("/update_rental")
    public String updateNow(@ModelAttribute Order order){
        service.updateOrder(order);
        return "redirect:/rental";
    }
}
