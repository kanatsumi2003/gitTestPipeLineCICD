    package com.demo.Controller;

import com.demo.Customer;
import com.demo.CustomerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @Operation(
            description = "Get all Customers",
            summary = "Get all of customers from list",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Failed",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping("v1/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    record NewcustomerRequest(String name, String email, int age ){

    }
    @PostMapping("/v1/customers")
    public void addCustomer(@RequestBody NewcustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);

    }
    @DeleteMapping("/v1/customers/{customerID}")
    public void deleteCustomer(@PathVariable("customerID") int id){
        customerRepository.deleteById(id);
    }

    @GetMapping("v1/customer/{customerID}")
    public Optional<Customer> searchCustomer(@PathVariable("customerID") int id){
        return customerRepository.findById(id);
    }

    @PutMapping("/v1/customers/{customerID}")
    public void updateCustomer(@PathVariable("customerID") int id, @RequestBody NewcustomerRequest request){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }
    record login(String userID, String password){

    }
    @GetMapping("/v2/customers")
    public login login(){
        return new login("Taboo", "123456");
    }
}
