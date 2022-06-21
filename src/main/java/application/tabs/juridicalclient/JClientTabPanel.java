package application.tabs.juridicalclient;

import application.tabs.TabPanel;
import model.JuridicalClient;
import services.CrudService;

public final class JClientTabPanel extends TabPanel<JuridicalClient> {
    public JClientTabPanel(CrudService<JuridicalClient> dataService) {
        super(dataService);

        actionPanel = new JClientActionPanel(dataService, new JClientInputDialog());
        objectPanel = new JClientObjectPanel(dataService.findAll(), actionPanel);
        actionPanel.setObjectPanel(objectPanel);

        initUI();
    }
}
