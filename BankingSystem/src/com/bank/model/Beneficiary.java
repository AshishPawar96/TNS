package com.bank.model;

public class Beneficiary {

    private int beneficiaryId;
    private int customerId;
    private String beneficiaryName;
    private String beneficiaryAccount;
    private String bankName;

    public Beneficiary() {
    }

    public Beneficiary(int beneficiaryId, int customerId,
                       String beneficiaryName,
                       String beneficiaryAccount,
                       String bankName) {
        this.beneficiaryId = beneficiaryId;
        this.customerId = customerId;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryAccount = beneficiaryAccount;
        this.bankName = bankName;
    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}