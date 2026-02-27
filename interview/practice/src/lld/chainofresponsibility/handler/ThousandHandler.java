package lld.chainofresponsibility.handler;

public class ThousandHandler extends MoneyHandler {

    private int numNotes;

    public ThousandHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {

        int notesNeeded = amount / 1000;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x Rs1000 notes.");

        int remainingAmount = amount - (notesNeeded * 1000);

        if (remainingAmount > 0) {
            if (nextHandler != null)
                nextHandler.dispense(remainingAmount);
            else
                System.out.println("Remaining amount of " + remainingAmount +
                        " cannot be fulfilled (Insufficient fund in ATM)");
        }
    }
}
