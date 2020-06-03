package com.example.nordic_motorhome.Models;
import javax.persistence.Entity;
import javax.persistence.Id;

//Theis (Benjamin support)
@Entity
public class Car {
    // This is a Java bean - Here we have created all variables, made a constructor and created getters and setters
    @Id
    private int idCars;
    private String model;
    private String brand;
    private int yearOfManufacture;
    private int yearOfPurchase;
    private int sleepingSpots;

    public Car() {
    }

    public Car(int idCars, String model, String brand, int yearOfManufacture, int yearOfPurchase, int sleepingSpots) {
        this.idCars = idCars;
        this.model = model;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.yearOfPurchase = yearOfPurchase;
        this.sleepingSpots = sleepingSpots;
    }

    public int getIdCars() {
        return idCars;
    }

    public void setIdCars(int idCar) {
        this.idCars = idCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getYearOfPurchase() {
        return yearOfPurchase;
    }

    public void setYearOfPurchase(int yearOfPurchase) {
        this.yearOfPurchase = yearOfPurchase;
    }

    public int getSleepingSpots() {
        return sleepingSpots;
    }

    public void setSleepingSpots(int sleepingSpots) {
        this.sleepingSpots = sleepingSpots;
    }
}

