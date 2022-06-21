package application.tabs.bank;

import application.tabs.ActionPanel;
import application.tabs.ObjectPanel;
import model.Bank;

import java.util.List;

public final class BankObjectPanel extends ObjectPanel<Bank> {

    public BankObjectPanel(List<Bank> objects, ActionPanel<Bank> actionPanel) {
        super(objects, actionPanel);
    }
}
