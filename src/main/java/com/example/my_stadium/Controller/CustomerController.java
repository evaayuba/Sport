package com.example.my_stadium.Controller;

import com.example.my_stadium.Model.Customer;
import com.example.my_stadium.Repository.CustomerRepo;
import com.example.my_stadium.Services.CustomerServices;
import com.example.my_stadium.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/all")
    public List<Customer> getAllCustomer() {
        return customerServices.findAll();
    }

    @PostMapping("/save")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerServices.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id) {
        Customer customer = customerServices.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return ResponseEntity.ok(customer);
    }

//    @PutMapping("/updates{cust_id}")
//    public  ResponseEntity<?>updates(@PathVariable int cust_id,@RequestBody Customer customer){
//        try {
//            if (customerServices.findById(cust_id).isPresent()){
//                Customer customer1 = customerServices.save(customer);
//                customer.setCust_id(customer1.getCust_id());
//                customer.setName(customer1.getName());
//                customer.setEmail(customer1.getEmail());
//                customer.setPhone(customer1.getPhone());
//            }
//        }
//    }

    @PutMapping("/updates/{cust_id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        Customer existingCustomer = customerServices.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        existingCustomer.setCust_id(customer.getCust_id());
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        Customer updatedCustomer = customerServices.addCustomer(existingCustomer);
        return ResponseEntity.ok(updatedCustomer);
    }


   @DeleteMapping("/delete{cust_id}")
   public  ResponseEntity<?>delete(@PathVariable int cust_id){
        try {
            customerServices.deleteById(cust_id);
            return  new ResponseEntity<>("succesfuly delete",HttpStatus.ACCEPTED);
        }catch (Exception exception){
            return  new ResponseEntity<>("error",HttpStatus.NOT_FOUND);
        }
   }

}
