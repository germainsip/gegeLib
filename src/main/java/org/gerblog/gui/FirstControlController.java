package org.gerblog.gui;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.awt.*;

public class FirstControlController {
    public JFXTextField field1;
    public Label lab1;
    public JFXCheckBox rougeCheck;


    public void labWrite(KeyEvent keyEvent) {
        lab1.setText(field1.getText());
    }

    public void rougeField(ActionEvent actionEvent) {
        if (rougeCheck.isSelected()){
            field1.focusColorProperty().set(Color.RED);
        } else {
            field1.focusColorProperty().set(Color.INDIGO);

        }
    }
}
