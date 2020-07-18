package org.gerblog.gui.champs;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.gerblog.tools.FenTool;
import org.gerblog.tools.Verification;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
       // webChamps.getEngine().load("https://germainsip.github.io/post/cours/java/javafxelmts/#les-champs-texte");
        loadCours("les-champs-texte");
    }

    /*public void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }*/
}
