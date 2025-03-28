package lld.adapter_design_pattern.Adapter;

import lld.adapter_design_pattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {

    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKgs() {
        double weightInPounds = weightMachine.getWeightInPounds();

        // convert it to kgs
        double weightInKgs = weightInPounds * 0.45;
        return weightInKgs;
    }
}
