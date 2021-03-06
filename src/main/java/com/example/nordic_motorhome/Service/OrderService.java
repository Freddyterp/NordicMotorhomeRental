package com.example.nordic_motorhome.Service;


import com.example.nordic_motorhome.Models.Order;
import com.example.nordic_motorhome.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Frederik
@Service
public class OrderService {
    // Creating a new object called Repo
    @Autowired
    OrderRepo Repo;

    // Service methods where we would clean up the data if needed - Pattern pure fabrication
    public List<Order> fecthAllItems() {return Repo.fetchAllItems();}

    public void addOrder(Order newOrder)
    {
        Repo.addOrder(newOrder);
    }

    public void deleteOrder(int id) {Repo.deleteOrder(id);}

    public void updateOrder(Order updatedOrder) {Repo.updateOrder(updatedOrder);}

    public Order findByID(int id) {return Repo.findOrderById(id); }

}
