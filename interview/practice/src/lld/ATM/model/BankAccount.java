package lld.ATM.model;

public class BankAccount {
    private int balance;
    private String bankNumber;
    private String pin;

    public BankAccount(int balance, String bankNumber, String pin) {
        this.balance = balance;
        this.bankNumber = bankNumber;
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }


}
