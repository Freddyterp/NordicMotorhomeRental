package com.example.nordic_motorhome.Service;

import com.example.nordic_motorhome.Models.Order;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//Frederik
public class OrderMapper implements RowMapper<Order> {
    public Order mapRow(ResultSet rs, int nownum) throws SQLException{
        Order order = new Order();
        order.setId(rs.getInt("idOrders"));
        order.setPrice(rs.getFloat("price"));
        order.setReservationDate(rs.getDate("reservationDate"));
        order.setStartDate(rs.getDate("startDate"));
        order.setEndDate(rs.getDate("endDate"));
        order.setReservedCar(rs.getInt("Cars_idCars"));
        order.setCustomer(rs.getInt("Customers_idCustomers"));

        return order;
    }
}
