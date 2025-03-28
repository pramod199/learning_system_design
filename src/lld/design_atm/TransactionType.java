package lld.design_atm;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showALlTransactionType() {
        for (TransactionType transactionType : TransactionType.values()) {
            System.out.println(transactionType.name());
        }
    }
}
