package application.tabs.credit;

import application.tabs.InputDialog;
import model.Credit;
import model.Currency;

import javax.swing.*;
import java.awt.*;

import static application.util.ValidatorUtil.isDouble;
import static application.util.ValidatorUtil.isNullOrEmpty;

public final class CreditInputDialog extends InputDialog<Credit> {

    private JTextField creditNameField;
    private JTextField creditTypeField;
    private JTextField creditPercentageField;

    public CreditInputDialog() {
        super();
        DIALOG_TITLE = "Input Credit Info";
    }

    @Override
    protected JPanel createInputPanel(Credit objectToEdit) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        creditNameField = new JTextField(objectToEdit != null? objectToEdit.getName() : "Credit Name");
        creditTypeField = new JTextField(objectToEdit != null? objectToEdit.getCreditType() : "Credit Type");
        creditPercentageField = new JTextField(objectToEdit != null? objectToEdit.getAnnualPercentage().toString() : "Credit Annual Percentage");

        panel.add(new JLabel("Enter Credit Name:"));
        panel.add(creditNameField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(new JLabel("Enter Credit Type:"));
        panel.add(creditTypeField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(new JLabel("Enter Credit Annual Percentage:"));
        panel.add(creditPercentageField);

        return panel;
    }

    @Override
    public String validateForm(){
        if (isNullOrEmpty(creditNameField)){
            return "Credit name cannot be empty!";
        }

        if (isNullOrEmpty(creditTypeField)){
            return "Credit type cannot be empty!";
        }

        if (isNullOrEmpty(creditPercentageField)){
            return "Credit Annual Percentage cannot be empty!";
        }

        if (!isDouble(creditPercentageField.getText())){
            return "Credit Annual Percentage must be a number! (no letters or symbols!)";
        }

        return null;
    }

    @Override
    protected Credit constructNewObject() {
        return new Credit(
                creditNameField.getText(),
                creditTypeField.getText(),
                Currency.currencyOf("MDL"),
                Double.valueOf(creditPercentageField.getText())
        );
    }
}
