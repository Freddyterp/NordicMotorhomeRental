package com.example.nordic_motorhome.Repository;

import com.example.nordic_motorhome.Models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Theis (Benjamin support)
@Repository
public class CarRepo {

    // Creating an object out of JDBCTemplate for us to use.
    @Autowired
    JdbcTemplate template;

    // Getting all items from the Cars Database
    public List<Car> fetchAllItems(){
        String sql = "SELECT * FROM Cars";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql,rowMapper);
    }

    // Adding a new Car to the database
    public void addCar(Car c){
        String sql = "INSERT INTO Cars (idCars, model, brand, yearOfManufacture, yearOfPurchase, sleepingSpots) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getIdCars(), c.getModel(), c.getBrand(), c.getYearOfManufacture(), c.getYearOfPurchase(), c.getSleepingSpots() );
    }

    // Deleting a car from the database by its id
    public void deleteCar(int id){
        String sql = "DELETE FROM Cars WHERE idCars=?";
        template.update(sql,id);
    }

    // Finding a car from the database by its id
    public Car findCarById(int id){
        String sql = "SELECT * FROM Cars WHERE idCars=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // Update a car from the database by its id
    public void updateCar(Car c){
        String sql = "UPDATE Cars SET model=?, brand=?, yearOfManufacture=?, yearOfPurchase=?, sleepingSpots=? WHERE idCars=?";
        template.update(sql, c.getModel(), c.getBrand(), c.getYearOfManufacture(), c.getYearOfPurchase(), c.getSleepingSpots(), c.getIdCars());
    }

}
