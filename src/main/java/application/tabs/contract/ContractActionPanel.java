package application.tabs.contract;

import application.tabs.ActionPanel;
import application.tabs.InputDialog;
import model.Contract;
import services.CrudService;

import javax.swing.*;

public final class ContractActionPanel extends ActionPanel<Contract> {

    private CrudService<Contract> dataService;
    private JButton incomeButton;

    public ContractActionPanel(CrudService<Contract> dataService, InputDialog<Contract> inputDialog) {
        super(dataService, inputDialog);

        this.dataService = dataService;
        createIncomeButton();
    }

    private void createIncomeButton(){
        incomeButton = new JButton("Income");
        incomeButton.setEnabled(false);

        incomeButton.addActionListener(e -> {
            JButton pressedButton = findPressedButton(objectPanel.getButtonList());
            if (pressedButton == null){
                throw new RuntimeException("No object button is pressed, yet Income button is not disabled!");
            }
            Contract contract = dataService.findByName(pressedButton.getText());
            if (contract == null){
                throw new RuntimeException("No credit exists with the same name as pressed button!");
            }
            double income = contract.calculateCreditIncome();
            JOptionPane.showMessageDialog(null, income, "Income: ", JOptionPane.PLAIN_MESSAGE);
        });

        addAndDisplayObjectDependedButton(incomeButton);
    }
}
