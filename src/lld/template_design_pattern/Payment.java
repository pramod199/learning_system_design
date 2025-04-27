package lld.template_design_pattern;

public abstract class Payment {
    public abstract void validateRequest();
    public abstract void calculateFees();

    public abstract void debitAmount();

    public abstract void creditAmount();

    // template method marked as final so no child class can override it.
    // but child class can override other methods. which allows for different implementation of specific steps.
    public final void sendMoney() {
        validateRequest();
        debitAmount();
        calculateFees();
        creditAmount();
    }
}
