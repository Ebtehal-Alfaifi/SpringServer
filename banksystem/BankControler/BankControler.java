package com.example.banksystem.BankControler;

import com.example.banksystem.ApiResponse.ApiResponse;
import com.example.banksystem.Model.CustomersModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class BankControler {
    ArrayList<CustomersModel> customers=new ArrayList<>();



    // DISPLAY ALL CUSTUMER

    @GetMapping("/get")
     public ArrayList<CustomersModel> getCustomers() {
         return customers;
     }

//ADD NEW CUSTUMER
@PostMapping("/add")
     public ApiResponse addCustomer(@RequestBody CustomersModel customer) {
        customers.add(customer);

         return new ApiResponse("Customer added successfully");
     }



     //UPDATE CUSTUMER
    @GetMapping("/update/{index}")
    public ApiResponse updateCustomer(@PathVariable int index  ,@RequestBody CustomersModel customer) {
        customers.set(index,  customer);
        return new ApiResponse("Customer updated successfully");
    }



//delet customer
@DeleteMapping("/delete/{index}")
public ApiResponse deleteCustomer(@PathVariable int index) {
       customers.remove(index);
        return new ApiResponse("Customer deleted successfully");
    }


    @PutMapping("/deposit/{index}")
    public ApiResponse costumerDeposit(@PathVariable int index,@RequestBody double amount) {
        if (index>=0&&index<customers.size()) {
            CustomersModel customer = customers.get(index);
            customer.setBalance(customer.getBalance()+amount);
            return new ApiResponse("Customer deposit successfully");
        }
        return new ApiResponse("Customer deposit failed");
    }

    @PutMapping("/withdraw/{index}")
    public ApiResponse costumerWithdrawal(@PathVariable int index,@RequestBody double amount) {
        if (index>=0&&index<customers.size()) {
            CustomersModel customer = customers.get(index);
            customer.setBalance(customer.getBalance()-amount);
            return new ApiResponse("Customer withdrawal successfully");
        }
        return new ApiResponse("Customer withdrawal failed");
    }




}
