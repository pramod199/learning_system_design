package lld_algomaster.splitwise;

import lld_algomaster.splitwise.entities.*;
import lld_algomaster.splitwise.enums.SplitType;
import lld_algomaster.splitwise.factory.SplitStrategyFactory;
import lld_algomaster.splitwise.strategy.SplitStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {
    private static SplitwiseService instance;

    private final Map<String, User> users = new HashMap<>();

    private final Map<String, Group> groups = new HashMap<>();

    private SplitwiseService() {

    }


    public static synchronized SplitwiseService getInstance() {
        if (instance == null) {
            instance = new SplitwiseService();
        }
        return instance;
    }

    // --- Setup Methods ---
    public User addUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Group addGroup(String name, List<User> members) {
        Group group = new Group(name, members);
        groups.put(group.getId(), group);
        return group;
    }

    public User getUser(String id) { return users.get(id); }
    public Group getGroup(String id) { return groups.get(id); }

    // --- Core Functional Methods (Facade) ---

    public Expense createExpense(String description, double amount, User paidBy, List<User> participants, List<Double> splitValues, SplitType splitType) {
        Expense expense = new Expense(description, amount, paidBy);
        SplitStrategy splitStrategy = SplitStrategyFactory.get(splitType);
        List<Split> splits = splitStrategy.calculateSplit(amount, paidBy, participants, splitValues);
        expense.setSplits(splits);

        for (Split split : splits) {
            User participant = split.getUser();
            double userAmount = split.getAmount();

            if (!paidBy.equals(participant)){
                paidBy.getBalanceSheet().adjustBalance(participant, userAmount);
                participant.getBalanceSheet().adjustBalance(paidBy, -userAmount);
            }
        }

        System.out.println("Expense '" + expense.getDescription() + "' of amount " + expense.getAmount() + " created.");
        return expense;
    }

    public synchronized void settleUp(String payerId, String payeeId, double amount) {
        User payer = users.get(payerId);
        User payee = users.get(payeeId);
        System.out.println(payer.getName() + " is settling up " + amount + " with " + payee.getName());
        // Settlement is like a reverse expense. payer owes less to payee.

        payee.getBalanceSheet().adjustBalance(payer, -amount);
        payer.getBalanceSheet().adjustBalance(payee, amount);
    }

    public void showBalanceSheet(String userId) {
        User user = users.get(userId);
        user.getBalanceSheet().showBalance();
    }


    public List<Transaction> simplifyGroupDebts(String groupId) {
        Group group = groups.get(groupId);
        if (group == null) throw new IllegalArgumentException("Group not found");

        // Calculate net balance for each member within the group context
        Map<User, Double> netBalances = new HashMap<>();
        for (User member : group.getMembers()) {
            double balance = 0;
            for (Map.Entry<User, Double> entry : member.getBalanceSheet().getBalances().entrySet()) {
                // Consider only balances with other group members
                if (group.getMembers().contains(entry.getKey())) {
                    balance += entry.getValue();
                }
            }
            netBalances.put(member, balance);
        }

        for (Map.Entry<User, Double> entry : netBalances.entrySet()) {
//            entry.getValue()
        }

        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }





}
