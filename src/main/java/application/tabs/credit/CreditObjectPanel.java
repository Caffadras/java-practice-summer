package application.tabs.credit;

import application.tabs.ActionPanel;
import application.tabs.ObjectPanel;
import model.Credit;

import java.util.List;

public final class CreditObjectPanel extends ObjectPanel<Credit> {
    public CreditObjectPanel(List<Credit> objects, ActionPanel<Credit> actionPanel) {
        super(objects, actionPanel);
    }
}
