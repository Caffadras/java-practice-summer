package application.tabs.bank;

import application.tabs.TabPanel;
import model.Bank;
import services.CrudService;

public final class BankTabPanel extends TabPanel<Bank> {

    public BankTabPanel(CrudService<Bank> dataService) {
        super(dataService);
        actionPanel = new BankActionPanel(dataService, new BankInputDialog());
        objectPanel = new BankObjectPanel(dataService.findAll(), actionPanel);
        actionPanel.setObjectPanel(objectPanel);

        initUI();
    }
}
