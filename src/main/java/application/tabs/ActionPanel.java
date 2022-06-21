package application.tabs;

import model.Nameable;
import services.CrudService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public abstract class ActionPanel<T extends Nameable> extends JPanel {
    private CrudService<T> dataService;
    protected ObjectPanel<T> objectPanel;
    private JPanel actionPanel;
    private final InputDialog<T> inputDialog;
    private JButton editButton;
    private JButton addButton;
    private JButton deleteButton;

    private List<JButton> objectDependedButtons;



    public ActionPanel(CrudService<T> dataService, InputDialog<T> inputDialog) {
        this.dataService = dataService;
        this.inputDialog = inputDialog;

        objectDependedButtons = new ArrayList<>();
        add(createActionPanel());
    }

    private JPanel createActionPanel(){
        actionPanel = new JPanel();

        editButton = new JButton("Edit");
        editButton.setEnabled(false);
        editButton.addActionListener(this::onEditButtonPressed);
        actionPanel.add(editButton);

        addButton = new JButton("Add");
        addButton.addActionListener(this::onAddButtonPressed);
        actionPanel.add(addButton);


        deleteButton= new JButton("Delete");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(this::onDeleteButtonPressed);
        actionPanel.add(deleteButton);

        objectDependedButtons.add(editButton);
        objectDependedButtons.add(deleteButton);

        return actionPanel;
    }

    public void onEditButtonPressed(ActionEvent e){
        final JButton pressedButton = findPressedButton(objectPanel.getButtonList());
        if(pressedButton == null) {
            throw new RuntimeException("No object button is pressed, yet editButton is not disabled!");
        }

        final T objectToEdit = dataService.findByName(pressedButton.getText());
        if(objectToEdit == null){
            throw new RuntimeException("No object exists with the same name as pressed button!");
        }
        inputDialog.showEditObjectDialog(objectToEdit);
        T editedObject = inputDialog.collectNewObject();
        if (editedObject == null) return;

        dataService.update(objectToEdit, editedObject);
        objectPanel.updateButtonFromObject(pressedButton, editedObject);
        objectPanel.enableAllButtons();

        setButtonsEnablement(false);
        triggerRepaint();
    }
    public void onAddButtonPressed(ActionEvent e){
        inputDialog.showNewObjectDialog();
        final T newObject = inputDialog.collectNewObject();
        if (newObject == null) return;
        dataService.save(newObject);
        objectPanel.addButtonFromObject(newObject);
        objectPanel.enableAllButtons();

        setButtonsEnablement(false);
        triggerRepaint();
    }
    public void onDeleteButtonPressed(ActionEvent e){
        final JButton pressedButton = findPressedButton(objectPanel.getButtonList());
        if(pressedButton == null) {
            throw new RuntimeException("No object button is pressed, yet deleteButton is not disabled!");
        }
        dataService.delete(dataService.findByName(pressedButton.getText()));
        objectPanel.deleteButton(pressedButton);
        objectPanel.enableAllButtons();

        setButtonsEnablement(false);
        triggerRepaint();
    }

    private void triggerRepaint(){
        revalidate();
        repaint();
    }

    public void setButtonsEnablement(boolean areEnabled){
        objectDependedButtons.forEach(button -> button.setEnabled(areEnabled));
    }

    public void setObjectPanel(ObjectPanel<T> objectPanel) {
        this.objectPanel = objectPanel;
    }

    public void addAndDisplayObjectDependedButton(JButton button){
        if (button == null) return;
        actionPanel.add(button);
        objectDependedButtons.add(button);
        triggerRepaint();
    }

    protected JButton findPressedButton(List<JButton> buttons){
        if (buttons == null) return null;
        return buttons.stream()
                .filter(button -> !button.isEnabled())
                .findFirst()
                .orElse(null);
    }
}
