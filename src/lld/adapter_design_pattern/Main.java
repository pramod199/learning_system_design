package lld.adapter_design_pattern;

import lld.adapter_design_pattern.Adaptee.WeightMachineForBabies;
import lld.adapter_design_pattern.Adapter.WeightMachineAdapter;
import lld.adapter_design_pattern.Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKgs());
    }
}
