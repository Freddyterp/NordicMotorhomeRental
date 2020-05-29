package com.example.nordic_motorhome.Models;

import com.example.nordic_motorhome.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
public class Order {


    @Id
    private int id;
    private float price;
    private Date startDate;
    private Date endDate;
    private Date reservationDate;
    private int reservedCar;
    private int customer;



    public Order(){

    }

    public Order(int id, float price, Date startDate, Date endDate, Date reservationDate, int carID, int customerID) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reservationDate = reservationDate;
        this.reservedCar = carID;
        this.customer = customerID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReservationDate() {
        return this.reservationDate;
    }

    public String getReservationDateAsString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(reservationDate);
    }


    public void setReservationDate(Date reservationDate){
        this.reservationDate = reservationDate;
    }

    public int getReservedCar()
    {
        return reservedCar;
    }

    public void setReservedCar(int reservedCar) {
        this.reservedCar = reservedCar;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
}
