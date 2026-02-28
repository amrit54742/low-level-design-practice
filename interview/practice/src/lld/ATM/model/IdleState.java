package lld.ATM.model;

public class IdleState implements ATMState{
    @Override
    public ATMState insertCard(ATM atm, Card card) {
        atm.setCard(card);
        System.out.println("Card inserted.");
        atm.setCurentATMState(atm.getHasACardState());
        return atm.getHasACardState();

    }

    @Override
    public ATMState verifyPin(ATM atm, String pin) {
        System.out.println("(hasCardState)please insert card first");
        return atm.getIdleState();
    }

    @Override
    public ATMState withdraw(ATM atm, int amountToDraw) {
        System.out.println("(authenticated)please insert card first");
        return atm.getIdleState();
    }

    @Override
    public int balance(ATM atm) {
        System.out.println("(balance)your card balance is " + atm.getCard().getBankAccount().getBalance());
        return atm.getCard().getBankAccount().getBalance();
    }
}
