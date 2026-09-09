package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Account;
import com.bank.util.DBConnection;

public class AccountDAO {

    // Add Account
    public void addAccount(Account account) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Account(account_id, customer_id, account_type, balance) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, account.getAccountId());
            ps.setInt(2, account.getCustomerId());
            ps.setString(3, account.getAccountType());
            ps.setDouble(4, account.getBalance());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Account Created Successfully.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View All Accounts
    public void viewAccounts() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Account";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------");
                System.out.println("Account ID   : " + rs.getInt("account_id"));
                System.out.println("Customer ID  : " + rs.getInt("customer_id"));
                System.out.println("Account Type : " + rs.getString("account_type"));
                System.out.println("Balance      : " + rs.getDouble("balance"));
            }

            if (!found) {
                System.out.println("No Accounts Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Deposit Money
    public void deposit(int accountId, double amount) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE Account SET balance = balance + ? WHERE account_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accountId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Amount Deposited Successfully.");
            } else {
                System.out.println("Account Not Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Withdraw Money
    public void withdraw(int accountId, double amount) {

        try {
            Connection con = DBConnection.getConnection();

            String checkSql = "SELECT balance FROM Account WHERE account_id = ?";

            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, accountId);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    String sql = "UPDATE Account SET balance = balance - ? WHERE account_id = ?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setDouble(1, amount);
                    ps.setInt(2, accountId);

                    ps.executeUpdate();

                    System.out.println("Amount Withdrawn Successfully.");

                } else {

                    System.out.println("Insufficient Balance.");
                }

            } else {

                System.out.println("Account Not Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Check Balance
    public void checkBalance(int accountId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT balance FROM Account WHERE account_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Current Balance : ₹" + rs.getDouble("balance"));

            } else {

                System.out.println("Account Not Found.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}