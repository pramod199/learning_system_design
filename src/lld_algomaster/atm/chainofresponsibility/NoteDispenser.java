package lld_algomaster.atm.chainofresponsibility;

public abstract class NoteDispenser {
    NoteDispenser next;
    private final int noteValue;
    private int numNotes;

    public NoteDispenser(int noteValue, int numNotes) {
        this.noteValue = noteValue;
        this.numNotes = numNotes;
    }

    public void setNext(NoteDispenser next) {
        this.next = next;
    }

    public synchronized void dispense(int amount) {
        if (amount >= noteValue) {
            int numToDispense = Math.min(amount / noteValue, this.numNotes);
            int remainingAmount = amount - (numToDispense * noteValue);

            if (numToDispense > 0) {
                System.out.println("Dispensing " + numToDispense + " x $" + noteValue + " note(s)");
                this.numNotes -= numToDispense;
            }

            if (remainingAmount > 0 && this.next != null) {
                this.next.dispense(remainingAmount);
            }
        } else if (this.next != null) {
            this.next.dispense(amount);
        }
    }

    public synchronized boolean canDispense(int amount) {
        if (amount < 0) return false;
        if (amount == 0) return true;

        int numToUse = Math.min(amount / noteValue, this.numNotes);
        int remainingAmount = amount - (numToUse * noteValue);

        if (remainingAmount == 0) return true;
        if (this.next != null) {
            return this.next.canDispense(remainingAmount);
        }
        return false;
    }
}
