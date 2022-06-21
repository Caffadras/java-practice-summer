package application.tabs.bank;

import application.tabs.ActionPanel;
import application.tabs.InputDialog;
import model.Bank;
import model.Contract;
import services.CrudService;

import javax.swing.*;

public final class BankActionPanel extends ActionPanel<Bank> {

    private JButton incomeButton;
    private CrudService<Bank> dataService;

    public BankActionPanel(CrudService<Bank> dataService, InputDialog<Bank> inputDialog) {
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
            Bank bank = dataService.findByName(pressedButton.getText());
            if (bank == null){
                throw new RuntimeException("No bank exists with the same name as pressed button!");
            }
            double totalIncome = 0.0d;
            if (bank.getContracts() != null){
                for (Contract contract : bank.getContracts()){
                    totalIncome += contract.calculateCreditIncome();
                }
            }
            JOptionPane.showMessageDialog(null, totalIncome, "Total income: ", JOptionPane.PLAIN_MESSAGE);
        });

        addAndDisplayObjectDependedButton(incomeButton);
    }
}
