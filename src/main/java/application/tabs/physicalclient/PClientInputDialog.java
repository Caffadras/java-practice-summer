package application.tabs.physicalclient;

import application.tabs.InputDialog;
import model.PhysicalClient;

import javax.swing.*;
import java.awt.*;

import static application.util.ValidatorUtil.*;

public final class PClientInputDialog extends InputDialog<PhysicalClient> {
    private JTextField clientNameField;
    private JTextField clientAddressField;
    private JTextField clientPhoneField;

    private JTextField clientPersonalCodeField;

    public PClientInputDialog() {
        super();
        DIALOG_TITLE = "Input Physical Client Info";
    }

    @Override
    protected JPanel createInputPanel(PhysicalClient objectToEdit) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        clientNameField = new JTextField(objectToEdit != null? objectToEdit.getName() : "");
        clientAddressField = new JTextField(objectToEdit != null? objectToEdit.getAddress() : "");
        clientPhoneField = new JTextField(objectToEdit != null? objectToEdit.getPhoneNumber() : "");
        clientPersonalCodeField = new JTextField(objectToEdit != null? objectToEdit.getPersonalCode().toString() : "");


        panel.add(new JLabel("Enter Client PersonalCode:"));
        panel.add(clientPersonalCodeField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Name:"));
        panel.add(clientNameField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Address:"));
        panel.add(clientAddressField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Client Phone:"));
        panel.add(clientPhoneField);

        return panel;
    }

    @Override
    public String validateForm() {
        if (isNullOrEmpty(clientNameField)){
            return "Bank name cannot be empty!";
        }

        if (isNullOrEmpty(clientPersonalCodeField)){
            return "Client Personal Code cannot be empty!";
        }

        if(!isLong(clientPersonalCodeField.getText())){
            return "Client Personal Code must be a number!";
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

        return null;
    }

    @Override
    protected PhysicalClient constructNewObject() {
        return new PhysicalClient(clientNameField.getText(),
                clientAddressField.getText(),
                clientPhoneField.getText(),
                Long.valueOf(clientPersonalCodeField.getText())
        );
    }
}
