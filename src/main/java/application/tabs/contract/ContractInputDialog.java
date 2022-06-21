package application.tabs.contract;

import application.tabs.InputDialog;
import model.Bank;
import model.Contract;
import model.Credit;
import services.CrudService;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import static application.util.ValidatorUtil.*;

public final class ContractInputDialog extends InputDialog<Contract> {

    private JTextField contractNumberField;
    private JTextField contractAgreementDateField;
    private JTextField contractTotalSumField;
    private JTextField contractRepaymentDateField;

    private JComboBox<String> bankComboBox;

    private JComboBox<String> creditComboCox;

    private final CrudService<Bank> bankListService;

    private final CrudService<Credit> creditListService;
    public ContractInputDialog(CrudService<Bank> bankListService, CrudService<Credit> creditListService) {
        this.bankListService = bankListService;
        this.creditListService = creditListService;

        DIALOG_TITLE = "Input Contract Info";
    }

    @Override
    protected JPanel createInputPanel(Contract objectToEdit) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        contractNumberField = new JTextField(objectToEdit != null? objectToEdit.getNumber().toString() : "");
        contractAgreementDateField = new JTextField(objectToEdit != null? objectToEdit.getAgreementDate().toString() : "");
        contractTotalSumField = new JTextField(objectToEdit != null? objectToEdit.getTotalSum().toString() : "");
        contractRepaymentDateField = new JTextField(objectToEdit != null? objectToEdit.getRepaymentDate().toString() : "");


        bankComboBox = createComboBoxFromObjects(bankListService.findAll(),
                objectToEdit == null? null : objectToEdit.getBank());
        creditComboCox = createComboBoxFromObjects(creditListService.findAll(),
                objectToEdit == null? null : objectToEdit.getCredit());


        panel.add(new JLabel("Enter Contract Number:"));
        panel.add(contractNumberField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Agreement Date:"));
        panel.add(contractAgreementDateField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Total Sum:"));
        panel.add(contractTotalSumField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Enter Repayment Date:"));
        panel.add(contractRepaymentDateField);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));

        panel.add(new JLabel("Choose a Bank:"));
        panel.add(bankComboBox);

        panel.add(new JLabel("Choose a Credit:"));
        panel.add(creditComboCox);
        return panel;
    }

    @Override
    public String validateForm() {
        if (contractNumberField.getText() == null || contractNumberField.getText().isEmpty()){
            return "Contract Number cannot be empty!";
        }

        if (!isLong(contractNumberField.getText())){
            return "Contract Number must not contain any symbols other than digits!";
        }

        if (isNullOrEmpty(contractAgreementDateField)){
            return "Contract Agreement Date cannot be empty!";
        }

        if (!isDate(contractAgreementDateField.getText())){
            return "Wrong Agreement Date format! (use yyyy-mm-dd)";
        }

        if (isNullOrEmpty(contractTotalSumField)){
            return "Contract Total Sum cannot me empty!";
        }

        if(!isDouble(contractNumberField.getText())){
            return "Contract Total Sum must not contain any symbols other than digits!";
        }

        if (isNullOrEmpty(contractRepaymentDateField)){
            return "Contract Agreement Date cannot be empty!";
        }

        if (!isDate(contractRepaymentDateField.getText())){
            return "Wrong Agreement Date format! (use yyyy-mm-dd)";
        }


        return null;
    }

    @Override
    protected Contract constructNewObject() {
        return new Contract(Long.valueOf(contractNumberField.getText()),
                LocalDate.parse(contractAgreementDateField.getText()),
                null,
                creditListService.findByName((String) creditComboCox.getSelectedItem()),
                Double.valueOf(contractTotalSumField.getText()),
                LocalDate.parse(contractRepaymentDateField.getText()),
                bankListService.findByName((String)(bankComboBox.getSelectedItem()))
        );
    }
}
