package org.gerblog.gui.champs;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LesChampsController {

    public Button sendButt;
    public TextField nomField;
    public TextField prenomField;
    public TextField telField;
    public PasswordField passField;
    public Label nomLab;
    public Label prenomLab;
    public Label telLab;
    public Label passLab;

    public void sendHandle(ActionEvent actionEvent) {
        nomLab.setText(nomField.getText());
        prenomLab.setText(prenomField.getText());
        telLab.setText(telField.getText());
        passLab.setText(passField.getText());
    }
}
