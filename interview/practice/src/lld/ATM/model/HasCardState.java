package lld.ATM.model;

public class HasCardState implements ATMState{
    @Override
    public ATMState insertCard(ATM atm, Card card) {
        System.out.println("(insertCard) wait!. you have already inserted your card");
        return atm.getHasACardState();
    }

    @Override
    public ATMState verifyPin(ATM atm, String pin) {
        Card card= atm.getCard();
        BankAccount bankAccount= card.getBankAccount();
        if (bankAccount.getPin().equals(pin)){
            System.out.println("(hasCardState) pin verified!!");
            atm.setCurentATMState(atm.getAuthenticatedState());
            return atm.getAuthenticatedState();
        } else {
            System.out.println("(hasCardState) pin not verified!!");
            atm.setCurentATMState(atm.getHasACardState());
            return atm.getHasACardState();
        }

    }

    @Override
    public ATMState withdraw(ATM atm, int amountToDraw) {
        System.out.println("(authenticated) insert pin first!!");
        return atm.getHasACardState();
    }

    @Override
    public int balance(ATM atm) {
        System.out.println("(balance)your card balance is " + atm.getCard().getBankAccount().getBalance());
        return atm.getCard().getBankAccount().getBalance();
    }
}
