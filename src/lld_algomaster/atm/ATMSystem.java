package lld_algomaster.atm;

import lld_algomaster.atm.chainofresponsibility.NoteDispenser;
import lld_algomaster.atm.chainofresponsibility.NoteDispenser100;
import lld_algomaster.atm.chainofresponsibility.NoteDispenser20;
import lld_algomaster.atm.chainofresponsibility.NoteDispenser50;
import lld_algomaster.atm.entities.BankService;
import lld_algomaster.atm.entities.Card;
import lld_algomaster.atm.entities.CashDispenser;
import lld_algomaster.atm.enums.OperationType;
import lld_algomaster.atm.state.ATMState;
import lld_algomaster.atm.state.IdleState;

public class ATMSystem {
    private static ATMSystem INSTANCE;
    private final BankService bankService;
    private final CashDispenser cashDispenser;
    private ATMState currentState;
    private Card currentCard;

    private ATMSystem() {
        this.currentState = new IdleState(this);
        this.bankService = new BankService();
        NoteDispenser c1 = new NoteDispenser100(10); // 10 x $100 notes
        NoteDispenser c2 = new NoteDispenser50(20); // 20 x $50 notes
        NoteDispenser c3 = new NoteDispenser20(30); // 30 x $20 notes
        c1.setNext(c2);
        c2.setNext(c3);

        this.cashDispenser = new CashDispenser(c1);
    }

    public static ATMSystem getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ATMSystem();
        }
        return INSTANCE;
    }

    public void changeState(ATMState newState) {
        this.currentState = newState;
    }

    public void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    // state method`s delegation
    public void insertCard(String cardNumber) {
        currentState.insertCard(cardNumber);
    }

    public void enterPin(String pin) {
        currentState.enterPin(pin);
    }

    public void selectOperation(OperationType op, int... args) {
        currentState.selectOperation(op, args);
    }

    public Card getCard(String cardNumber) {
        return bankService.getCard(cardNumber);
    }

    public boolean authenticate(String pin) {
        return bankService.authenticate(currentCard, pin);
    }

    public void checkBalance() {
        double balance = bankService.getBalance(currentCard);
        System.out.printf("Your current account balance is: $%.2f%n", balance);
    }

    public void withdrawCash(int amount) {
        if (!cashDispenser.canDispenseCash(amount)) {
            throw new IllegalStateException("Insufficient cash available in the ATM.");
        }

        bankService.withdrawMoney(currentCard, amount);

        try {
            cashDispenser.dispenseCash(amount);
        } catch (Exception e) {
            bankService.depositMoney(currentCard, amount); // Deposit back if dispensing fails
        }
    }

    public void depositCash(int amount) {
        bankService.depositMoney(currentCard, amount);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public BankService getBankService() {
        return bankService;
    }



}
