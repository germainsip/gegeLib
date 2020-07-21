package org.gerblog.gui.pie;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Slider;
import org.gerblog.tools.FenTool;

import java.net.URL;
import java.util.ResourceBundle;

public class LesPiechartsController extends FenTool implements Initializable, ChangeListener {
    public Slider cursOne;
    public Slider cursTwo;
    public Slider cursThree;
    public PieChart pieReglable;
    public BarChart histo;
    ObservableList<PieChart.Data> pieChartData;
    XYChart.Series dataSerie ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadCours("les-diagrammes-et-les-histogrammes");

        loadChart();
        loadHisto();
        cursOne.valueProperty().addListener(this);
        cursTwo.valueProperty().addListener(this);
        cursThree.valueProperty().addListener(this);
    }



    public void loadChart() {
        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Java", cursOne.getValue()),
                new PieChart.Data("PHP", cursTwo.getValue()),
                new PieChart.Data("C#", cursThree.getValue())
        );
        pieReglable.setData(pieChartData);
    }

    public void loadHisto(){
        dataSerie = new XYChart.Series<String,Number>();
        dataSerie.getData().add(new XYChart.Data<String,Number>("Java",cursOne.getValue()));
        dataSerie.getData().add(new XYChart.Data<String,Number>("PHP",cursTwo.getValue()));
        dataSerie.getData().add(new XYChart.Data<String,Number>("C#",cursThree.getValue()));
        histo.getData().clear();
        histo.getData().add(dataSerie);
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        loadChart();
        loadHisto();
    }
}
