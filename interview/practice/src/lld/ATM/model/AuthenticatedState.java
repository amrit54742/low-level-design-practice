package lld.ATM.model;

public class AuthenticatedState implements ATMState{
    @Override
    public ATMState insertCard(ATM atm, Card card) {
        System.out.println("(insertCard) wait!. you have already inserted your card");
        return atm.getAuthenticatedState();
    }

    @Override
    public ATMState verifyPin(ATM atm, String pin) {
        System.out.println("(insertCard) pin has been already verified");
        return atm.getHasACardState();
    }

    @Override
    public ATMState withdraw(ATM atm, int amountToDraw) {
        Card card= atm.getCard();
        BankAccount bankAccount= card.getBankAccount();
        if (amountToDraw > bankAccount.getBalance()){
            System.out.println("(authenticated) not enough balance..");    // no need to set the current state as authenticated since it is already in authenticated state
            return atm.getAuthenticatedState();
        } else {
            System.out.println("(authenticated) doing transaction");
            int newAmount= bankAccount.getBalance() - amountToDraw;
            bankAccount.setBalance(newAmount);
            atm.setCurentATMState(atm.getIdleState());
            return atm.getIdleState();
        }
    }

    @Override
    public int balance(ATM atm) {
        System.out.println("(balance) wait for some time " + atm.getCard().getBankAccount().getBalance());
        return atm.getCard().getBankAccount().getBalance();
    }
}
