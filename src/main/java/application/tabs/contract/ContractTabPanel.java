package application.tabs.contract;

import application.tabs.TabPanel;
import model.Bank;
import model.Contract;
import model.Credit;
import services.CrudService;

public final class ContractTabPanel extends TabPanel<Contract> {
    public ContractTabPanel(CrudService<Contract> contractListService, CrudService<Bank> bankListService,
                            CrudService<Credit> creditListService) {
        super(contractListService);

        actionPanel = new ContractActionPanel(contractListService, new ContractInputDialog(bankListService, creditListService));
        objectPanel = new ContractObjectPanel(contractListService.findAll(), actionPanel);
        actionPanel.setObjectPanel(objectPanel);

        initUI();
    }
}
