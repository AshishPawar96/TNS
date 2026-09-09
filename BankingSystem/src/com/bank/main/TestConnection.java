package com.bank.main;

import java.sql.Connection;
import com.bank.util.DBConnection;

public class TestConnection {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Connection Successful!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}