package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Transaction;
import com.bank.util.DBConnection;

public class TransactionDAO {

    // Add Transaction
    public void addTransaction(Transaction transaction) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Transactions(transaction_id, account_id, transaction_type, amount, transaction_date) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, transaction.getTransactionId());
            ps.setInt(2, transaction.getAccountId());
            ps.setString(3, transaction.getTransactionType());
            ps.setDouble(4, transaction.getAmount());
            ps.setString(5, transaction.getTransactionDate());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Transaction Added Successfully.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Transactions
    public void viewTransactions(int accountId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Transactions WHERE account_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("--------------------------------");
                System.out.println("Transaction ID : " + rs.getInt("transaction_id"));
                System.out.println("Account ID     : " + rs.getInt("account_id"));
                System.out.println("Type           : " + rs.getString("transaction_type"));
                System.out.println("Amount         : " + rs.getDouble("amount"));
                System.out.println("Date           : " + rs.getString("transaction_date"));
            }

            if (!found) {
                System.out.println("No transactions found for Account ID : " + accountId);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}