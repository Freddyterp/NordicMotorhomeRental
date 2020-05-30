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

    @Autowired
    JdbcTemplate template;

    public List<Car> fetchAllItems(){
        String sql = "SELECT * FROM Cars";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(sql,rowMapper);
    }

    public void addCar(Car c){
        String sql = "INSERT INTO Cars (idCars, model, brand, yearOfManufacture, yearOfPurchase, sleepingSpots) VALUES (?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getIdCars(), c.getModel(), c.getBrand(), c.getYearOfManufacture(), c.getYearOfPurchase(), c.getSleepingSpots() );
    }
    public void deleteCar(int id){
        //tilføj parameter som kan teste om det lykkedes at slette
        String sql = "DELETE FROM Cars WHERE idCars=?";
        template.update(sql,id);
    }

    public Car findCarById(int id){
        String sql = "SELECT * FROM Cars WHERE idCars=?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public void updateCar(Car c){
        String sql = "UPDATE Cars SET model=?, brand=?, yearOfManufacture=?, yearOfPurchase=?, sleepingSpots=? WHERE idCars=?";
        template.update(sql, c.getModel(), c.getBrand(), c.getYearOfManufacture(), c.getYearOfPurchase(), c.getSleepingSpots(), c.getIdCars());
    }

}
