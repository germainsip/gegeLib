package org.gerblog.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import org.gerblog.gui.exemple.ExempleTileController;

import java.io.IOException;

public class GuiTool {
    /**
     * Génère une tuile avec bouton et commentaire
     *
     * @param name    nom du bouton
     * @param comment commentaire lié au bouton
     * @param listBox VBOX dans laquelle est intégré la tuile
     * @throws IOException
     */
    public static void genExemple(String name, String comment, VBox listBox) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(GuiTool.class.getResource("/org/gerblog/gui/exemple/exemple_tile.fxml"));
        Parent ex = fxmlLoader.load();
        ExempleTileController controller = fxmlLoader.<ExempleTileController>getController();
        controller.setValues(name, comment);
        listBox.getChildren().add(ex);
    }

    public static String route(String evenement) {
        return switch (evenement) {
            //inscrire ici le couple nom du bouton et package/nom du fxml
            case "Les Boutons" -> "buttons/les_boutons";
            case "Les champs texte" -> "champs/les_champs";
            //case "Les Sliders" -> "sliders/les_sliders";
            default -> "default";
        };
    }
}
