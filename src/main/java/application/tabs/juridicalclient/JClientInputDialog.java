package application.tabs.juridicalclient;

import application.tabs.InputDialog;
import model.JuridicalClient;

import javax.swing.*;
import java.awt.*;

import static application.util.ValidatorUtil.*;

public final class JClientInputDialog extends InputDialog<JuridicalClient> {
    private JTextField clientNameField;
    private JTextField clientAddressField;
    private JTextField clientPhoneField;

    private JTextField clientFiscalCode;
    private JTextField clientPropertyType;
    private JTextField clientAdministratorName;
    private JTextField clientContactPerson;

    public JClientInputDialog() {
        DIALOG_TITLE = "Input Juridical Client Info:";
    }

    @Override
    protected JPanel createInputPanel(JuridicalClient objectToEdit) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        clientFiscalCode = new JTextField(objectToEdit != null? objectToEdit.getFiscalCode().toString() : "");
        clientNameField = new JTextField(objectToEdit != null? objectToEdit.getName() : "");
        clientAddressField = new JTextField(objectToEdit != null? objectToEdit.getAddress() : "");
        clientPhoneField = new JTextField(objectToEdit != null? objectToEdit.getPhoneNumber() : "");
        clientPropertyType = new JTextField(objectToEdit != null? objectToEdit.getPropertyType() : "");
        clientAdministratorName = new JTextField(objectToEdit != null? objectToEdit.getAdministratorName(): "");
        clientContactPerson = new JTextField(objectToEdit != null? objectToEdit.getContactPerson() : "");


        panel.add(new JLabel("Enter Client Fiscal Code:"));
        panel.add(clientFiscalCode);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Name:"));
        panel.add(clientNameField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Address:"));
        panel.add(clientAddressField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Phone:"));
        panel.add(clientPhoneField);

        panel.add(new JLabel("Enter Client Property Type:"));
        panel.add(clientPropertyType);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Administrator Name:"));
        panel.add(clientAdministratorName);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Contact Person:"));
        panel.add(clientContactPerson);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        return panel;
    }

    @Override
    public String validateForm() {
        if (isNullOrEmpty(clientFiscalCode)){
            return "Client Fiscal Code cannot be empty!";
        }

        if(!isLong(clientFiscalCode.getText())){
            return "Client Fiscal Code must be a number!";
        }

        if (isNullOrEmpty(clientNameField)){
            return "Client name cannot be empty!";
        }

        if (isNullOrEmpty(clientAddressField)){
            return "Client address cannot be empty!";
        }

        if (isNullOrEmpty(clientPhoneField)){
            return "Client phone cannot be empty!";
        }

        if (!isPhoneFormat(clientPhoneField.getText())){
            return "Wrong phone format! (no letters or symbols!)";
        }

        if (isNullOrEmpty(clientPropertyType)){
            return "Client Property cannot me empty!";
        }
        if (isNullOrEmpty(clientAdministratorName)){
            return "Client Administrator Name cannot be empty!";
        }

        if (isNullOrEmpty(clientContactPerson)){
            return "Client Contact Person cannot be empty!";
        }
        return null;
    }

    @Override
    protected JuridicalClient constructNewObject() {
        return new JuridicalClient(clientNameField.getText(),
                clientAddressField.getText(),
                clientPhoneField.getText(),
                Long.valueOf(clientFiscalCode.getText()),
                clientPropertyType.getText(),
                clientAdministratorName.getText(),
                clientContactPerson.getText()
        );
    }
}
