package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Customer;
import com.bank.util.DBConnection;

public class CustomerDAO {

    // Add Customer
    public void addCustomer(Customer customer) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Customer(customer_id, name, address, contact) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getContact());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Customers
    public void viewCustomers() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Customer";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("------------------------------");
                System.out.println("Customer ID : " + rs.getInt("customer_id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Address     : " + rs.getString("address"));
                System.out.println("Contact     : " + rs.getString("contact"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}