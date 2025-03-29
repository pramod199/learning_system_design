package lld.command_design_pattern;

public class AirCondition {
    boolean isOn;
    int temperature;

    public void turnOnAc(){
        isOn = true;
        System.out.println("AC is on");
    }

    public void turnOffAc(){
        isOn = false;
        System.out.println("AC is off");
    }

    public void setTemperature(int temp){
        temperature = temp;
        System.out.println("Temperature set to " + temp);
    }
}
