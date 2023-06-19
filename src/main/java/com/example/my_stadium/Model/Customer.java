package com.example.my_stadium.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Customer {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cust_id;
    private String name;
    private String email;
    private int phone;

    public Customer(int cust_id, String name, String email, int phone) {
        this.cust_id = cust_id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer(){

    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
