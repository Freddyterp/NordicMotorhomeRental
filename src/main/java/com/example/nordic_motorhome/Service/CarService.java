package com.example.nordic_motorhome.Service;


import com.example.nordic_motorhome.Models.Car;
import com.example.nordic_motorhome.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Theis (Benjamin support)
@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public List<Car> fetchAllItems(){
        return carRepo.fetchAllItems();
    }

    public void addCar(Car c){

        carRepo.addCar(c);
    }
    public void deleteCar(int id){
        carRepo.deleteCar(id);
    }

    public void updateCar(Car c){
        carRepo.updateCar(c);
    }

    public Car findById(int id){
        return carRepo.findCarById(id);
    }






}
