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
import org.gerblog.tools.GuiTool;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
        String action = switch (evenement) {
            //inscrire ici le couple nom du bouton et package/nom du fxml
            case "Les Boutons" -> "buttons/les_boutons";
            case "Les champs texte" -> "champs/les_champs";
            //case "Les Sliders" -> "sliders/les_sliders";
            default -> "default";
        };

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

       /* for (String key : ex.elmts.keySet()) {
            try {
                GuiTool.genExemple(key, ex.elmts.get(key),listBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        for (Exemple exT : ex1.exTab) {
            try {
                GuiTool.genExemple(exT.getName(), exT.getComment(), listBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /*private void genExemple(String name, String comment) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/gerblog/gui/exemple/exemple_tile.fxml"));
        Parent ex = fxmlLoader.load();
        ExempleTileController controller = fxmlLoader.<ExempleTileController>getController();
        controller.setValues(name,comment);
        listBox.getChildren().add(ex);
    }*/
}
