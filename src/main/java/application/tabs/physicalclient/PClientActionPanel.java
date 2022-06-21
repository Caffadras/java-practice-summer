package application.tabs.physicalclient;

import application.tabs.ActionPanel;
import application.tabs.InputDialog;
import model.PhysicalClient;
import services.CrudService;

public final class PClientActionPanel extends ActionPanel<PhysicalClient> {
    public PClientActionPanel(CrudService<PhysicalClient> dataService, InputDialog<PhysicalClient> inputDialog) {
        super(dataService, inputDialog);
    }
}
