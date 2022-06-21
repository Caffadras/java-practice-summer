package application.tabs.physicalclient;

import application.tabs.TabPanel;
import model.PhysicalClient;
import services.CrudService;

public final class PClientTabPanel extends TabPanel<PhysicalClient> {
    public PClientTabPanel(CrudService<PhysicalClient> dataService) {
        super(dataService);
        actionPanel = new PClientActionPanel(dataService, new PClientInputDialog());
        objectPanel = new PClientObjectPanel(dataService.findAll(), actionPanel);
        actionPanel.setObjectPanel(objectPanel);

        initUI();
    }
}
