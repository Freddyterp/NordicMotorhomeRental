package com.example.nordic_motorhome.Controller;

import com.example.nordic_motorhome.Models.Car;
import com.example.nordic_motorhome.Models.Customer;
import com.example.nordic_motorhome.Service.CarService;
import com.example.nordic_motorhome.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


//Theis (Benjamin support)
@Controller
public class MainController {

    // Creating an object of CarService
    @Autowired
    CarService carService;


    // Getting all data from the database and showing to the tabel on index page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cars", carService.fetchAllItems());
        return "index";
    }

    // Shwoing the create car page
    @GetMapping("/create")
    public String showCreatePage(){
        return "create";
    }

    // Saving all the inserted data into the Car database and redirecting to index.html
    @PostMapping("/create")
    public String create(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/";
    }

    // Delete the car by its id - Showing a pop up the page, therefore the page will just redirect to index.
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        carService.deleteCar(id);
        return "redirect:/";
    }

    // Getting the update.html car and loading all the information from the CarId and insert into the form
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute( "car", carService.findById(id));
        return "update";
    }

    // Saving the updated data back to the database and redirecting to index.html page.
    @PostMapping("/update")
    public String updateNow(@ModelAttribute Car car){
        carService.updateCar(car);
        return "redirect:/";
    }

}

