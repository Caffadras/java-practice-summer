package application.tabs;

import application.util.DialogUtil;
import model.Nameable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class InputDialog<T> implements ActionListener {

    protected String DIALOG_TITLE = "Input dialog";
    private T newObject;

    public InputDialog(){
    }

    protected abstract JPanel createInputPanel(T objectToEdit);

    public void showNewObjectDialog(){
        new DialogUtil(DIALOG_TITLE, createInputPanel(null), this::validateForm, this, this);
    }

    public T collectNewObject() {
        T returnObject = newObject;
        setNewObject(null);
        return returnObject;
    }

    public void showEditObjectDialog(T objectToEdit){
        new DialogUtil(DIALOG_TITLE, createInputPanel(objectToEdit), this::validateForm, this, this);
    }

    public abstract String validateForm();
    private void setNewObject(T newObject) {
        this.newObject = newObject;
    }

    protected <S extends Nameable> JComboBox<String> createComboBoxFromObjects(List<S> objects, S objectToEdit){
        JComboBox<String> comboBox;
        if (objects == null){
            comboBox = new JComboBox<>();
            if (objectToEdit != null){
                throw new RuntimeException("Object to edit: \""+objectToEdit.getName()+"\"is not in the objects list!");
            }
        }
        else{
            comboBox = new JComboBox<>(objects.stream()
                    .map(S::getName)
                    .toArray(String[]::new));
            comboBox.addItem(null);
            if(objectToEdit != null && !objects.contains(objectToEdit)){
                throw new RuntimeException("Object to edit: \""+objectToEdit.getName()+"\"is not in the objects list!");
            }
        }
        comboBox.setSelectedItem(objectToEdit == null? null : objectToEdit.getName());
        return comboBox;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setNewObject(constructNewObject());
    }

    protected abstract T constructNewObject();
}
