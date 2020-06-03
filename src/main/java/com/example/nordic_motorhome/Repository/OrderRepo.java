package com.example.nordic_motorhome.Repository;


import com.example.nordic_motorhome.Models.Order;
import com.example.nordic_motorhome.Service.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

//Frederik
@Repository
public class OrderRepo{

    // Creating an object from the JDBCTemplate class
    @Autowired
    JdbcTemplate template;


    // Getting all orders from the database
    public List<Order> fetchAllItems(){
        String sql = "SELECT * FROM Orders";
        List<Order> orders = template.query(sql, new OrderMapper());
        return orders;
    }

    // Creating a new order and save it to the database
    public void addOrder(Order newOrder){
        String sql = "INSERT INTO orders (idOrders, price, reservationDate, startDate, endDate, Cars_idCars, Customers_idCustomers) VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, newOrder.getId(), newOrder.getPrice(), newOrder.getReservationDate(), newOrder.getStartDate(), newOrder.getEndDate(),
                        newOrder.getReservedCar(), newOrder.getCustomer());
    }

    // Deleting an order from the database
    public void deleteOrder(int id){
        String sql = "DELETE FROM orders WHERE idOrders=?";
        template.update(sql,id);
    }

    // Find a order in the database by its id
    public Order findOrderById(int id){
        String sql = "SELECT * FROM orders WHERE idOrders=?";
        Order order = template.queryForObject(sql, new OrderMapper(), id);
        return order;
    }

    // Updating a order in the database by its id.
    public void updateOrder(Order updatedOrder){
        String sql = "UPDATE orders SET price=?, reservationDate=?, startDate=?, EndDate=?, Cars_idCars=?, Customers_idCustomers=? WHERE idOrders=?";
        template.update(sql, updatedOrder.getPrice(), updatedOrder.getReservationDate(), updatedOrder.getStartDate(), updatedOrder.getEndDate(),
                        updatedOrder.getReservedCar(), updatedOrder.getCustomer(), updatedOrder.getId());
    }

}
