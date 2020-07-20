package org.gerblog.tools;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public abstract class FenTool {
    public WebView webView;
    public JFXButton fermeButt;

    public void loadCours(String link){
        webView.getEngine().load(String.format("https://germainsip.github.io/post/cours/java/javafxelmts/#%s", link));

    }
    public void closeHandle(ActionEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
