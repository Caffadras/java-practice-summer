package application.tabs.physicalclient;

import application.tabs.ActionPanel;
import application.tabs.ObjectPanel;
import model.PhysicalClient;

import java.util.List;

public final class PClientObjectPanel extends ObjectPanel<PhysicalClient> {
    public PClientObjectPanel(List<PhysicalClient> objects, ActionPanel<PhysicalClient> actionPanel) {
        super(objects, actionPanel);
    }
}
