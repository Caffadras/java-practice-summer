package application.tabs.bank;

import application.tabs.InputDialog;
import model.Bank;

import javax.swing.*;
import java.awt.*;

import static application.util.ValidatorUtil.isNullOrEmpty;
import static application.util.ValidatorUtil.isPhoneFormat;

public final class BankInputDialog extends InputDialog<Bank> {

    private JTextField bankNameField;
    private JTextField bankAddressField;
    private JTextField bankPhoneField;

    public BankInputDialog() {
        super();
        DIALOG_TITLE = "Input Bank Info";
    }

    @Override
    protected JPanel createInputPanel(Bank objectToEdit) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        bankNameField = new JTextField(objectToEdit != null? objectToEdit.getName() : "Bank Name");
        bankAddressField = new JTextField(objectToEdit != null? objectToEdit.getAddress() : "Bank Address");
        bankPhoneField = new JTextField(objectToEdit != null? objectToEdit.getPhoneNumber() : "Bank Phone");

        panel.add( new JLabel("Enter Bank Name:"));
        panel.add(bankNameField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add( new JLabel("Enter Bank Address:"));
        panel.add(bankAddressField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add( new JLabel("Enter Bank Phone:"));
        panel.add(bankPhoneField);

        return panel;
    }

    @Override
    public String validateForm(){
        if (isNullOrEmpty(bankNameField)){
            return "Bank name cannot be empty!";
        }

        if (isNullOrEmpty(bankAddressField)){
            return "Bank address cannot be empty!";
        }

        if (isNullOrEmpty(bankPhoneField)){
            return "Bank phone cannot be empty!";
        }

        if (!isPhoneFormat(bankPhoneField.getText())){
            return "Wrong phone format! (no letters or symbols!)";
        }

        return null;
    }

    @Override
    protected Bank constructNewObject() {
        return new Bank(bankNameField.getText(),
                bankAddressField.getText(),
                bankPhoneField.getText(),
                null
        );
    }
}
