package lld.ATM.model;

public class ATM {
    private Card card;
    private ATMState curentATMState;
    private ATMState idleState;
    private ATMState hasACardState;
    private ATMState authenticatedState;

    public ATM() {
        this.curentATMState= new IdleState();
        this.idleState= new IdleState();
        this.hasACardState= new HasCardState();
        this.authenticatedState= new AuthenticatedState();
    }


    public void insertCard(Card card) {
        curentATMState.insertCard(this, card);
    }

    public void enterPin(String pin) {
        curentATMState.verifyPin(this, pin);
    }

    public void withdraw(int amount) {
        curentATMState.withdraw(this, amount);
    }

    public void checkBalance() {
        curentATMState.balance(this);
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ATMState getCurentATMState() {
        return curentATMState;
    }

    public void setCurentATMState(ATMState curentATMState) {
        this.curentATMState = curentATMState;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public void setIdleState(ATMState idleState) {
        this.idleState = idleState;
    }

    public ATMState getHasACardState() {
        return hasACardState;
    }

    public void setHasACardState(ATMState hasACardState) {
        this.hasACardState = hasACardState;
    }

    public ATMState getAuthenticatedState() {
        return authenticatedState;
    }

    public void setAuthenticatedState(ATMState authenticatedState) {
        this.authenticatedState = authenticatedState;
    }



}
