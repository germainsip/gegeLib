package org.gerblog.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public Button lesBoutons;

    public void ouvreButtonScene(ActionEvent actionEvent) throws IOException {
        Stage buttonStage = new Stage();
        Parent buttonRoot = FXMLLoader.load(getClass().getResource("/org/gerblog/gui/buttons/lesboutons.fxml"));
        Scene buttScene = new Scene(buttonRoot);
        buttonStage.setScene(buttScene);
        buttonStage.show();
    }
}
