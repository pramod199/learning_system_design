package memento.configuration_memento;

public class Client {
    public static void main(String[] args) {
        ConfigurationCareTaker configurationCareTaker = new ConfigurationCareTaker();
        // initiate state of the originator
        ConfigurationOriginator originatorObj = new ConfigurationOriginator(100, 200);

        // save it
        ConfigurationMemento snapshot1 = originatorObj.createMemento();

        // add it to history
        configurationCareTaker.addMemento(snapshot1);

        originatorObj.setHeight(7);
        originatorObj.setWidth(8);

        // save it
        ConfigurationMemento snapshot2 = originatorObj.createMemento();
        configurationCareTaker.addMemento(snapshot2);

        // originator changing to new state
        originatorObj.setWidth(14);
        originatorObj.setHeight(15);

        // undo
        ConfigurationMemento restoredStateMementoObj = configurationCareTaker.undo();
        originatorObj.restore(restoredStateMementoObj);

        System.out.println("Height: " + originatorObj.height + " Width: " + originatorObj.width);


    }
}
