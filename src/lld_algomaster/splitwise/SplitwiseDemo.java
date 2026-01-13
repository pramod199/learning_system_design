package lld_algomaster.splitwise;

import lld_algomaster.splitwise.entities.Group;
import lld_algomaster.splitwise.entities.User;
import lld_algomaster.splitwise.enums.SplitType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitwiseDemo {
    public static void main(String[] args) {
        // 1. Setup the service
        SplitwiseService service = SplitwiseService.getInstance();

        // 2. Create users and groups
        User alice = service.addUser("Alice", "alice@a.com");
        User bob = service.addUser("Bob", "bob@b.com");
        User charlie = service.addUser("Charlie", "charlie@c.com");
        User david = service.addUser("David", "david@d.com");


        Group friendsGroup = service.addGroup("Friends Trip", List.of(alice, bob, charlie, david));

        System.out.println("--- System Setup Complete ---\n");

        // 3. Use Case 1: Equal Split

        System.out.println("--- Use Case 1: Equal Split ---");
        service.createExpense("Dinner",
                1000,
                alice,
                Arrays.asList(alice, bob, charlie, david),
                new ArrayList<>(),
                SplitType.EQUAL
        );

        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());
        System.out.println();


        // 4. Use Case 2: Exact Split
        System.out.println("--- Use Case 2: Exact Split ---");
        service.createExpense("Movie Tickets",
                370,
                alice,
                Arrays.asList(bob, charlie),
                Arrays.asList(120.0, 250.0),
                SplitType.EXACT
        );

        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());
        System.out.println();


        System.out.println("--- Balances After All Expenses ---");
        service.showBalanceSheet(alice.getId());
        service.showBalanceSheet(bob.getId());

        service.showBalanceSheet(charlie.getId());
        service.showBalanceSheet(david.getId());

        System.out.println();
    }

}
