package com.bank.main;

import com.bank.dao.CustomerDAO;
import com.bank.model.Customer;

public class CustomerTest {

    public static void main(String[] args) {

        Customer customer = new Customer();

        customer.setCustomerId(101);
        customer.setName("Rahul Sharma");
        customer.setAddress("Mumbai");
        customer.setContact("9876543210");

        CustomerDAO dao = new CustomerDAO();
        dao.addCustomer(customer);

        System.out.println("\nCustomer Details:");
        dao.viewCustomers();
    }
}