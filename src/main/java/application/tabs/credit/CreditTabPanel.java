package application.tabs.credit;

import application.tabs.TabPanel;
import model.Credit;
import services.CrudService;

public final class CreditTabPanel extends TabPanel<Credit> {
    public CreditTabPanel(CrudService<Credit> dataService) {
        super(dataService);

        actionPanel = new CreditActionPanel(dataService, new CreditInputDialog());
        objectPanel = new CreditObjectPanel(dataService.findAll(), actionPanel);
        actionPanel.setObjectPanel(objectPanel);

        initUI();
    }
}
