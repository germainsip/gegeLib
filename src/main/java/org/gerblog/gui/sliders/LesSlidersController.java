package org.gerblog.gui.sliders;

import com.jfoenix.controls.JFXSlider;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Arc;
import org.gerblog.tools.FenTool;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ResourceBundle;

public class LesSlidersController extends FenTool implements Initializable, ChangeListener {
    public Slider hSlide;
    public Slider vSlide;
    public Label horizonLab;
    public Label verticalLab;
    public JFXSlider hSliderJFX;
    public Arc greenArc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCours("les-slider");
        hSlide.valueProperty().addListener(this);
        vSlide.valueProperty().addListener(this);
        hSliderJFX.valueProperty().addListener(this);
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        Format df = new DecimalFormat("#.##");
        String horizonValue = df.format(hSlide.getValue());
        String verticalValue = df.format(vSlide.getValue());

        horizonLab.setText("H: " + horizonValue);
        verticalLab.setText("V: "+verticalValue);
        greenArc.setLength(hSliderJFX.getValue());
    }
}
