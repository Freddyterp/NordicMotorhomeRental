package com.example.nordic_motorhome.Repository;



import com.example.nordic_motorhome.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
//Theis (Benjamin support)
@Repository
public class CustomerRepo {

    // Creating an object from the JDBCTemplate class
    @Autowired
    JdbcTemplate template;

    // Getting all customers from the database
    public List<Customer> fetchAllItems(){
        String sql = "SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql,rowMapper);
    }

    // Adding a customer to the database
    public void addCustomer(Customer c){
        String sql = "INSERT INTO customers (idCustomers, fName, lName, Address, phone_Number, email, driverlicense) VALUES (?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, c.getIdCustomers(), c.getfName(), c.getlName(), c.getAddress(), c.getPhone_number(), c.getEmail(), c.getDriverlicense() );
    }

    // Deleting a customer from the database by its ID
    public void deleteCustomer(int id){
        String sql = "DELETE FROM customers WHERE idCustomers=?";
        template.update(sql,id);
    }

    // Finding a customer in the database by its id
    public Customer findById(int id){
        String sql = "SELECT * FROM customers WHERE idCustomers=?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    // Updating a customer in the database by its id
    public void updateCustomer(Customer c){
        String sql = "UPDATE customers SET fName=?, lName=?, Address=?, phone_number=?, email=?, driverlicense=? WHERE idCustomers=?";
        template.update(sql, c.getfName(), c.getlName(), c.getAddress(), c.getPhone_number(), c.getEmail(), c.getDriverlicense(), c.getIdCustomers());
    }




}
