package com.bank.main;

import java.util.Scanner;

import com.bank.dao.AccountDAO;
import com.bank.dao.BeneficiaryDAO;
import com.bank.dao.CustomerDAO;
import com.bank.dao.TransactionDAO;
import com.bank.model.Account;
import com.bank.model.Beneficiary;
import com.bank.model.Customer;
import com.bank.model.Transaction;

public class BankingApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerDAO customerDAO = new CustomerDAO();
        AccountDAO accountDAO = new AccountDAO();
        BeneficiaryDAO beneficiaryDAO = new BeneficiaryDAO();
        TransactionDAO transactionDAO = new TransactionDAO();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("         BANKING SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. View Customers");
            System.out.println("6. View Accounts");
            System.out.println("7. View Transactions");
            System.out.println("8. View Beneficiaries");
            System.out.println("9. Deposit Money");
            System.out.println("10. Withdraw Money");
            System.out.println("11. Check Balance");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // Part 2 starts from here
            case 1:

                Customer customer = new Customer();

                System.out.print("Enter Customer ID: ");
                customer.setCustomerId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                customer.setName(sc.nextLine());

                System.out.print("Enter Address: ");
                customer.setAddress(sc.nextLine());

                System.out.print("Enter Contact: ");
                customer.setContact(sc.nextLine());

                customerDAO.addCustomer(customer);

                break;

            case 2:

                Account account = new Account();

                System.out.print("Enter Account ID: ");
                account.setAccountId(sc.nextInt());

                System.out.print("Enter Customer ID: ");
                account.setCustomerId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Account Type (Savings/Current): ");
                account.setAccountType(sc.nextLine());

                System.out.print("Enter Initial Balance: ");
                account.setBalance(sc.nextDouble());

                accountDAO.addAccount(account);

                break;

            case 3:

                Beneficiary beneficiary = new Beneficiary();

                System.out.print("Enter Beneficiary ID: ");
                beneficiary.setBeneficiaryId(sc.nextInt());

                System.out.print("Enter Customer ID: ");
                beneficiary.setCustomerId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Beneficiary Name: ");
                beneficiary.setBeneficiaryName(sc.nextLine());

                System.out.print("Enter Beneficiary Account Number: ");
                beneficiary.setBeneficiaryAccount(sc.nextLine());

                System.out.print("Enter Bank Name: ");
                beneficiary.setBankName(sc.nextLine());

                beneficiaryDAO.addBeneficiary(beneficiary);

                break;

            case 4:

                Transaction transaction = new Transaction();

                System.out.print("Enter Transaction ID: ");
                transaction.setTransactionId(sc.nextInt());

                System.out.print("Enter Account ID: ");
                transaction.setAccountId(sc.nextInt());

                sc.nextLine();

                System.out.print("Enter Transaction Type (Deposit/Withdraw): ");
                transaction.setTransactionType(sc.nextLine());

                System.out.print("Enter Amount: ");
                transaction.setAmount(sc.nextDouble());

                sc.nextLine();

                System.out.print("Enter Transaction Date (YYYY-MM-DD): ");
                transaction.setTransactionDate(sc.nextLine());

                transactionDAO.addTransaction(transaction);

                break;
                
            case 5:

                System.out.println("\n===== Customer Details =====");
                customerDAO.viewCustomers();

                break;

            case 6:

                System.out.println("\n===== Account Details =====");
                accountDAO.viewAccounts();

                break;

            case 7:

                System.out.print("Enter Account ID: ");
                int accountId = sc.nextInt();

                System.out.println("\n===== Transaction History =====");
                transactionDAO.viewTransactions(accountId);

                break;
            case 8:

                System.out.print("Enter Customer ID: ");
                int customerId = sc.nextInt();

                System.out.println("\n===== Beneficiary Details =====");
                beneficiaryDAO.viewBeneficiaries(customerId);

                break;

            case 9:

                System.out.print("Enter Account ID: ");
                int depositAccountId = sc.nextInt();

                System.out.print("Enter Deposit Amount: ");
                double depositAmount = sc.nextDouble();

                accountDAO.deposit(depositAccountId, depositAmount);

                break;

            case 10:

                System.out.print("Enter Account ID: ");
                int withdrawAccountId = sc.nextInt();

                System.out.print("Enter Withdraw Amount: ");
                double withdrawAmount = sc.nextDouble();

                accountDAO.withdraw(withdrawAccountId, withdrawAmount);

                break;

            case 11:

                System.out.print("Enter Account ID: ");
                int balanceAccountId = sc.nextInt();

                accountDAO.checkBalance(balanceAccountId);

                break;

            case 12:

                System.out.println("\nThank You for Using Banking System!");
                break;

            default:

                System.out.println("\nInvalid Choice! Please Try Again.");

            }

        } while (choice != 12);

        sc.close();
        System.out.println("Thank you for using Banking System!");

    }
}