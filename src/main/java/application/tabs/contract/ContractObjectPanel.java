package application.tabs.contract;

import application.tabs.ActionPanel;
import application.tabs.ObjectPanel;
import model.Contract;

import java.util.List;

public final class ContractObjectPanel extends ObjectPanel<Contract> {
    public ContractObjectPanel(List<Contract> objects, ActionPanel<Contract> actionPanel) {
        super(objects, actionPanel);
    }
}
