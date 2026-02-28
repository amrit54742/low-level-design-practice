package lld.ATM.model;

public interface ATMState {

    ATMState insertCard(ATM atm, Card card);
    ATMState verifyPin (ATM atm, String pin);
    ATMState withdraw(ATM atm, int amountToDraw);
    int balance(ATM atm);

}
