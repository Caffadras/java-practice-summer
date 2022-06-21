package application.tabs.juridicalclient;

import application.tabs.ActionPanel;
import application.tabs.InputDialog;
import model.JuridicalClient;
import services.CrudService;

public final class JClientActionPanel extends ActionPanel<JuridicalClient> {
    public JClientActionPanel(CrudService<JuridicalClient> dataService, InputDialog<JuridicalClient> inputDialog) {
        super(dataService, inputDialog);
    }
}
