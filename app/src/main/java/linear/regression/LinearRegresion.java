package linear.regression;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import java.util.List;

public class LinearRegresion extends HBox {


    public LinearRegresion(){

        getChildren().addAll(new Label("sdsd"), graph());
    }

    public Region graph() {

        List<XYChart.Data<Number, Number>> puntos = List.of(
                new XYChart.Data<>(1, 2),
                new XYChart.Data<>(2, 3),
                new XYChart.Data<>(3, 5)
        );

        XYChart.Series<Number, Number> seriesPuntos = new XYChart.Series<>();
        seriesPuntos.setName("Datos");
        seriesPuntos.getData().addAll(puntos);
        LineChart<Number, Number> lineChart = new LineChart<>(new NumberAxis(), new NumberAxis());
        lineChart.getData().add(seriesPuntos);
        lineChart.lookup(".series0.chart-series-line").setStyle("-fx-stroke: transparent;");


        double sumX = 0, sumY = 0, sumXY = 0, sumXX = 0;
        int n = puntos.size();

        for (XYChart.Data<Number, Number> p : puntos) {
            double x = p.getXValue().doubleValue();
            double y = p.getYValue().doubleValue();
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXX += x * x;
        }

        double a = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double b = (sumY - a * sumX) / n;



        double xMin = puntos.stream().mapToDouble(p -> p.getXValue().doubleValue()).min().getAsDouble();
        double xMax = puntos.stream().mapToDouble(p -> p.getXValue().doubleValue()).max().getAsDouble();

        XYChart.Series<Number, Number> seriesRegresion = new XYChart.Series<>();
        seriesRegresion.setName("Regresión lineal");
        seriesRegresion.getData().add(new XYChart.Data<>(xMin, a * xMin + b));
        seriesRegresion.getData().add(new XYChart.Data<>(xMax, a * xMax + b));

// Añadir la línea de regresión al chart
        lineChart.getData().add(seriesRegresion);

       return  lineChart;

    }
}
