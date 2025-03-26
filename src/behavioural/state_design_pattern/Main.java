package behavioural.state_design_pattern;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        JButton home = new JButton("Home");
        home.addActionListener(e-> phone.getState().onHome());
        JButton lock = new JButton("Lock");
        lock.addActionListener(e-> phone.getState().onLock());

    }
}
