package org.gerblog.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.gerblog.libexemple.Exemple;
import org.gerblog.tools.Exempliser;
import org.gerblog.tools.FenTool;
import org.gerblog.tools.GuiTool;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends FenTool implements Initializable {
    public Hyperlink lienCours;
    public VBox listBox;
    final static Exemple ex = new Exemple();
    public Hyperlink lienJavadoc;
    private static double xOffset;
    private static double yOffset;

    /**
     * La méthode prend le texte du bouton et envoie le fxml correspondant
     *
     * @param actionEvent
     * @throws IOException
     */
    public static void ouvreSceneExemple(ActionEvent actionEvent) throws IOException {
        Button btn = (Button) actionEvent.getSource();
        String evenement = btn.getText();
        String action = GuiTool.route(evenement);

        // génère et lance un stage avec les éléments fournis
        Stage exempleStage = new Stage();
        Parent exempleRoot = loadFenExemple(action);
        Scene buttScene = new Scene(exempleRoot);
        exempleStage.setScene(buttScene);
        // enlève la bordure os de la le fenêtre
        exempleStage.initStyle(StageStyle.UNDECORATED);
        exempleStage.show();

        // Méthodes pour permettre le dragg de la fenêtre
        buttScene.setOnMousePressed(event -> {
            xOffset = exempleStage.getX() - event.getScreenX();
            yOffset = exempleStage.getY() - event.getScreenY();
        });
        buttScene.setOnMouseDragged(event -> {
            exempleStage.setX(event.getScreenX() + xOffset);
            exempleStage.setY(event.getScreenY() + yOffset);
        });
    }

    /**
     * Méthode de chargement des fxml
     *
     * @param chemin
     * @return
     * @throws IOException
     */
    public static Parent loadFenExemple(String chemin) throws IOException {
        return FXMLLoader.load(MainController.class.getResource("/org/gerblog/gui/" + chemin + ".fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Exempliser ex1 = new Exempliser();
        System.out.println(ex1.exTab[0].getComment());
        lienCours.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(URI.create("https://germainsip.github.io/post/cours/java/javafxelmts/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        lienJavadoc.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(URI.create("https://openjfx.io/javadoc/14/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        for (Exemple exT : ex1.exTab) {
            try {
                GuiTool.genExemple(exT.getName(), exT.getComment(), listBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
