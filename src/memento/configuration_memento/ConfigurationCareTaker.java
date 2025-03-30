package memento.configuration_memento;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {

    List<ConfigurationMemento> history = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento) {
        history.add(memento);
    }

    public ConfigurationMemento undo() {
        if (history.isEmpty()) {
            return null;
        }

        int lastMementoIndex = history.size() - 1;
        // get last mememto
        ConfigurationMemento lastMemento = history.get(lastMementoIndex);
        // remove last memento
        history.remove(lastMemento);
        return lastMemento;
    }
}
