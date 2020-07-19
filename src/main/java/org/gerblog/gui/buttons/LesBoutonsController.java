package org.gerblog.gui.buttons;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import org.gerblog.tools.FenTool;

import java.net.URL;
import java.util.ResourceBundle;

public class LesBoutonsController extends FenTool implements Initializable {

    public WebView buttonWebview;
    public Button btn1;
    public Button btn2;
    public Label res;
    public Button fermeButt;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCours("les-button-et-label");
    }

    /**
     * Cette méthode récupère le texte du bouton cliqué
     * et envoie le texte "Le [bouton n°] vient d'être cliqué"
     * au label res
     *
     * @param actionEvent
     */
    public void writeOnLabel(ActionEvent actionEvent) {
        // récupération du bouton cliqué
        Button btnActive = (Button) actionEvent.getSource();
        //construction du message avec le texte du bouton
        String message = "Le " + btnActive.getText() + " vient d'être cliqué!";
        //envoie du message dans le label
        res.setText(message);
    }



}
