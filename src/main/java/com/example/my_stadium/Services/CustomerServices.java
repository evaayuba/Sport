package com.example.my_stadium.Services;

import com.example.my_stadium.Model.Customer;
import com.example.my_stadium.Model.Manager;
import com.example.my_stadium.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepo.findById(id);
    }
// Assuming you have a CustomerRepo interface autowired in your class

    public Manager save(Customer existingCustomer) {
        // Implement the logic to save the existing customer
        // You can use customerRepo.save(existingCustomer) or any other appropriate method
        // Make sure to return the Manager object as per your implementation
        // Replace the method body with the appropriate implementation
        return null;
    }

    public void deleteById(Integer id) {
        customerRepo.deleteById(id);
    }

    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    public void create(Customer customer) {
        customerRepo.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer) {
        Customer existingCustomer = customerRepo.findById(id).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setName(customer.getName());
            existingCustomer.setPhone(customer.getPhone());
            customerRepo.save(existingCustomer);
        }
    }
    public void delete(Integer id){customerRepo.deleteById(id);}
}


