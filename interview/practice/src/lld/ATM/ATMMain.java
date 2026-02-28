package lld.ATM;


import lld.ATM.model.ATM;
import lld.ATM.model.BankAccount;
import lld.ATM.model.Card;

public class ATMMain {
    public static void main(String[] args) {
        BankAccount bankAccount= new BankAccount(2000, "ABCDE", "AMRIT");
        Card card= new Card(bankAccount);
        ATM atm= new ATM();
        atm.insertCard(card);
        atm.enterPin("AMRIT");
        atm.withdraw(5000);
        atm.checkBalance();

    }
}
