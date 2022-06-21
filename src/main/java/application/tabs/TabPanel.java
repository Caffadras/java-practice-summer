package application.tabs;

import model.Nameable;
import services.CrudService;

import javax.swing.*;
import java.awt.*;

public abstract class TabPanel<T extends Nameable> extends JPanel {

    protected ActionPanel<T> actionPanel;
    protected ObjectPanel<T> objectPanel;

    protected final CrudService<T> dataService;

    public TabPanel(CrudService<T> dataService) {
        this.dataService = dataService;
    }

    protected void initUI(){
        setLayout(new BorderLayout());
        add(objectPanel);
        add(actionPanel, BorderLayout.PAGE_END);
    }
}
