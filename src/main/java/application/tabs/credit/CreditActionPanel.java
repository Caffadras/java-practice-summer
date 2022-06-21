package application.tabs.credit;

import application.tabs.ActionPanel;
import application.tabs.InputDialog;
import model.Credit;
import services.CrudService;

public final class CreditActionPanel extends ActionPanel<Credit> {
    public CreditActionPanel(CrudService<Credit> dataService, InputDialog<Credit> inputDialog) {
        super(dataService, inputDialog);
    }
}
