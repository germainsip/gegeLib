package org.gerblog.gui.champs;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.gerblog.tools.FenTool;
import org.gerblog.tools.Verification;

import java.net.URL;
import java.util.ResourceBundle;

public class LesChampsController extends FenTool implements Initializable {

    public Button sendButt;
    public TextField nomField;
    public TextField prenomField;
    public TextField telField;
    public PasswordField passField;
    public Label nomLab;
    public Label prenomLab;
    public Label telLab;
    public Label passLab;
    public JFXButton fermButt;


    public void sendHandle() {

        Boolean flagChampNom,flagChampPrenom,flagChampTel;

        if (Verification.verifTexte(nomField.getText()) ) {
            nomField.setStyle("");
            flagChampNom = true;
        } else {
            nomField.setStyle("-fx-border-color: darkred");
            flagChampNom = false;
        }if (Verification.verifTexte(prenomField.getText()) ) {
            prenomField.setStyle("");
            flagChampPrenom = true;
        } else {
            nomField.setStyle("-fx-border-color: darkred");
            flagChampPrenom = false;
        }if (Verification.verifNum(telField.getText()) ) {
            telField.setStyle("");
            flagChampTel = true;
        } else {
            telField.setStyle("-fx-border-color: darkred");
            flagChampTel = false;
        }

        if (flagChampNom && flagChampPrenom && flagChampTel) sendField();
    }

    private void sendField() {
        nomLab.setText(nomField.getText());
        prenomLab.setText(prenomField.getText());
        telLab.setText(telField.getText());
        passLab.setText(passField.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCours("les-champs-texte");
    }


}
