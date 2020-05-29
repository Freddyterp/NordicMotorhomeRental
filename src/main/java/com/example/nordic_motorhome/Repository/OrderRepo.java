package com.example.nordic_motorhome.Repository;


import com.example.nordic_motorhome.Models.Order;
import com.example.nordic_motorhome.Service.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class OrderRepo{

    @Autowired
    JdbcTemplate template;

    public List<Order> fetchAllItems(){
        String sql = "SELECT * FROM Orders";
        List<Order> orders = template.query(sql, new OrderMapper());
        return orders;
    }

    public void addOrder(Order newOrder){
        String sql = "INSERT INTO orders (idOrders, price, reservationDate, startDate, endDate, Cars_idCars, Customers_idCustomers) VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, newOrder.getId(), newOrder.getPrice(), newOrder.getReservationDate(), newOrder.getStartDate(), newOrder.getEndDate(),
                        newOrder.getReservedCar(), newOrder.getCustomer());
    }
    public void deleteOrder(int id){
        //tilføj parameter som kan teste om det lykkedes at slette
        String sql = "DELETE FROM orders WHERE idOrders=?";
        template.update(sql,id);
    }

    public Order findOrderById(int id){
        String sql = "SELECT * FROM orders WHERE idOrders=?";
        Order order = template.queryForObject(sql, new OrderMapper(), id);
        return order;
    }

    public void updateOrder(Order updatedOrder){
        String sql = "UPDATE orders SET price=?, reservationDate=?, startDate=?, EndDate=?, Cars_idCars=?, Customers_idCustomers=? WHERE idOrders=?";
        template.update(sql, updatedOrder.getPrice(), updatedOrder.getReservationDate(), updatedOrder.getStartDate(), updatedOrder.getEndDate(),
                        updatedOrder.getReservedCar(), updatedOrder.getCustomer(), updatedOrder.getId());
    }

}
