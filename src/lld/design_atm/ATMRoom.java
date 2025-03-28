package lld.design_atm;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();


        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.user.card, "1234");
        atmRoom.atm.getCurrentATMState().selectOperation( atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal( atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();


    }

    private void initialize() {

        //create ATM
        atm = ATM.getInstance();
        atm.setAtmBalance(3500, 1,2,5);

        //create User
        this.user = createUser();

    }

    private User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){
        BankAccount bankAccount = createBankAccount();
        Card card = new Card("card-number", "1234", bankAccount);
        return card;
    }

    private BankAccount createBankAccount() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.balance = 3000;

        return bankAccount;

    }

}
