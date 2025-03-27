package lld.design_library_management_system;

import java.util.Date;

public class LibraryCard {
    private int cardId;
    private Date issueDate;
    private boolean active;

    public boolean isActive() {
        return active;
    }
}
