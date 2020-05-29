package com.example.nordic_motorhome.Models;

public class Customer {
    private int idCustomers;
    private String fName;
    private String lName;
    private String Address;
    private int phone_number;
    private String email;
    private String driverlicense;

    public Customer(int idCustomers, String fName, String lName, String Address, int phone_number, String email, String driverlicense) {
        this.idCustomers = idCustomers;
        this.fName = fName;
        this.lName = lName;
        this.Address = Address;
        this.phone_number = phone_number;
        this.email = email;
        this.driverlicense = driverlicense;
    }

    public Customer() {
    }

    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String adress) {
        Address = adress;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverlicense() {
        return driverlicense;
    }

    public void setDriverlicense(String driverlicense) {
        this.driverlicense = driverlicense;
    }
}