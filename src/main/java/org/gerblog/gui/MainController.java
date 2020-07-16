package org.gerblog.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.effects.JFXDepthManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.gerblog.gui.exemple.ExempleTileController;
import org.gerblog.libexemple.Exemple;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public Hyperlink lienCours;
    public VBox listBox;
    final static Exemple ex = new Exemple();

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
            case "Les boutons" -> "buttons/les_boutons";
            case "Les champs texte" -> "champs/les_champs";
            //case "Les Sliders" -> "sliders/les_sliders";
            default -> "default";
        };

        // génère et lance un stage avec les éléments fournis
        Stage exempleStage = new Stage();
        Parent exempleRoot = loadFenExemple(action);
        Scene buttScene = new Scene(exempleRoot);
        exempleStage.setScene(buttScene);
        exempleStage.show();
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
        lienCours.setOnAction(event -> {
            try {
                Desktop.getDesktop().browse(URI.create("https://germainsip.github.io/post/cours/java/javafxelmts/"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        for (String key : ex.elmts.keySet()) {
            try {
                genExemple(key, ex.elmts.get(key));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void genExemple(String name, String comment) throws IOException {
        /*HBox boiteExemple = new HBox();
        JFXDepthManager.setDepth(boiteExemple, 1);
        JFXButton button = new JFXButton(name);
        button.setStyle("-fx-background-color: #88BA3F");
        button.setPrefWidth(200);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setOnAction(actionEvent -> {
            try {
                ouvreSceneExemple(actionEvent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        boiteExemple.setSpacing(10);
        boiteExemple.setPrefWidth(539);
        boiteExemple.setPrefHeight(47);
        boiteExemple.setPadding(new Insets(10));
        boiteExemple.setAlignment(Pos.CENTER_LEFT);
        //InnerShadow ombre = new InnerShadow();
        boiteExemple.setStyle("-fx-background-color: white");
        //boiteExemple.setEffect(ombre);

        boiteExemple.getChildren().addAll(button, new Label(comment));*/
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/gerblog/gui/exemple/exemple_tile.fxml"));
        Parent ex = fxmlLoader.load();
        ExempleTileController controller = fxmlLoader.<ExempleTileController>getController();
        controller.setValues(name,comment);
       // listBox.getChildren().add(boiteExemple);
        listBox.getChildren().add(ex);
    }
}
