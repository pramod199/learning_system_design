package lld_algomaster.atm.state;

import lld_algomaster.atm.ATMSystem;
import lld_algomaster.atm.enums.OperationType;

public class AuthenticatedState implements ATMState {
    ATMSystem atmSystem;
    public AuthenticatedState(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Error: A card is already inserted and a session is active.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Error: PIN has already been entered and authenticated.");
    }

    @Override
    public void selectOperation(OperationType op, int... args) {
        switch (op) {
            case CHECK_BALANCE:
                atmSystem.checkBalance();
                break;

            case WITHDRAW_CASH:
                if (args.length == 0 || args[0] <= 0) {
                    System.out.println("Error: Invalid withdrawal amount specified.");
                    break;
                }
                int amountToWithdraw = args[0];

                double accountBalance = atmSystem.getBankService().getBalance(atmSystem.getCurrentCard());

                if (amountToWithdraw > accountBalance) {
                    System.out.println("Error: Insufficient balance.");
                    break;
                }

                System.out.println("Processing withdrawal for $" + amountToWithdraw);
                // Delegate the complex withdrawal logic to the ATM's dedicated method
                atmSystem.withdrawCash(amountToWithdraw);
                break;

            case DEPOSIT_CASH:
                if (args.length == 0 || args[0] <= 0) {
                    System.out.println("Error: Invalid withdrawal amount specified.");
                    break;
                }
                int amountToDeposit = args[0];
                System.out.println("Processing deposit for $" + amountToDeposit);
                atmSystem.depositCash(amountToDeposit);
                break;

            default:
                System.out.println("Error: Invalid operation selected.");
                break;
        }
        // End the session after one transaction
        System.out.println("Transaction complete.");
        ejectCard();

    }

    @Override
    public void ejectCard() {
        System.out.println("Ending session. Card has been ejected. Thank you for using our ATM.");
        atmSystem.setCurrentCard(null);
        atmSystem.changeState(new IdleState(atmSystem));
    }
}
