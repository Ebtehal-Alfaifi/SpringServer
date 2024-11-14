package com.example.banksystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomersModel {
   // Customers Class : ID , Username , Balance
    private String Id;
    private String userName;
    private double Balance;

}
