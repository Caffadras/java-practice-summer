package application.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class DialogUtil {
    private JOptionPane optionPane;
    private JDialog dialog;


    public DialogUtil(String title, JPanel dialogPanel, Supplier<String> validator,
                      ActionListener listener, Object eventOwner){
        createNewFormDialog(title, dialogPanel, validator, listener, eventOwner);
    }

    private void createNewFormDialog(String title, JPanel dialogPanel,Supplier<String> validator,
                                     ActionListener listener, Object eventOwner){
        optionPane = new JOptionPane(
                dialogPanel,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION);

        dialog = new JDialog((JFrame) null,
                title,
                true);

        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setPropertyListener(validator, listener, eventOwner);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void setPropertyListener(Supplier<String> validator, ActionListener listener, Object eventOwner){
        optionPane.addPropertyChangeListener(e -> {
            if (!dialog.isVisible()) return;

            if ((int) e.getNewValue() == JOptionPane.OK_OPTION) {
                String validateResult = validator.get();
                if (validateResult != null){
                    optionPane.setValue(-1);
                    JOptionPane.showConfirmDialog(null,
                            validateResult,
                            "Invalid Input",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.ERROR_MESSAGE);
                } else{
                    listener.actionPerformed(new ActionEvent(eventOwner,
                            (int)System.currentTimeMillis(),
                            "validation passed"));
                    dialog.setVisible(false);
                }
            }
            else if ((int)e.getNewValue() == JOptionPane.CANCEL_OPTION){
                dialog.setVisible(false);
            }
        });
    }

}
