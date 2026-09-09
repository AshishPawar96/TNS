package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.model.Beneficiary;
import com.bank.util.DBConnection;

public class BeneficiaryDAO {

    // Add Beneficiary
    public void addBeneficiary(Beneficiary beneficiary) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Beneficiary(beneficiary_id, customer_id, beneficiary_name, beneficiary_account, bank_name) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, beneficiary.getBeneficiaryId());
            ps.setInt(2, beneficiary.getCustomerId());
            ps.setString(3, beneficiary.getBeneficiaryName());
            ps.setString(4, beneficiary.getBeneficiaryAccount());
            ps.setString(5, beneficiary.getBankName());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Beneficiary Added Successfully.");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Beneficiaries by Customer ID
    public void viewBeneficiaries(int customerId) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Beneficiary WHERE customer_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("Beneficiary ID : " + rs.getInt("beneficiary_id"));
                System.out.println("Customer ID    : " + rs.getInt("customer_id"));
                System.out.println("Name           : " + rs.getString("beneficiary_name"));
                System.out.println("Account No.    : " + rs.getString("beneficiary_account"));
                System.out.println("Bank Name      : " + rs.getString("bank_name"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}