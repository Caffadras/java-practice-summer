package application.tabs.juridicalclient;

import application.tabs.ActionPanel;
import application.tabs.ObjectPanel;
import model.JuridicalClient;

import java.util.List;

public final class JClientObjectPanel extends ObjectPanel<JuridicalClient> {
    public JClientObjectPanel(List<JuridicalClient> objects, ActionPanel<JuridicalClient> actionPanel) {
        super(objects, actionPanel);
    }
}
