package application.tabs;

import model.Nameable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjectPanel<T extends Nameable> extends JPanel{
    private final List<JButton> buttonList = new ArrayList<>();

    protected final ActionPanel<T> actionPanel;
    public ObjectPanel(List<T> objects, ActionPanel<T> actionPanel){
        this.actionPanel = actionPanel;
        convertObjectListToButtons(objects);
    }

    private void convertObjectListToButtons(List<T> objects){
        for (T object : objects){
            add(createButtonFromObject(object));
        }
    }
    private JButton createButtonFromObject(T object) {
        JButton newButton = new JButton(object.getName());
        newButton.addActionListener(e -> {
            buttonList.forEach(button -> button.setEnabled(true));
            newButton.setEnabled(false);
            actionPanel.setButtonsEnablement(true);
        });
        buttonList.add(newButton);
        return newButton;
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    public void deleteButton(JButton button){
        buttonList.remove(button);
        button.setVisible(false);
    }

    public void addButtonFromObject(T object ){
        add(createButtonFromObject(object));
    }

    public void updateButtonFromObject(JButton button, T object){
        button.setText(object.getName());
    }


    public void enableAllButtons(){
        buttonList.forEach(button -> button.setEnabled(true));
    }
}
