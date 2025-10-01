package linear.regression;

import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;

public class CustomLineChart<N> extends LineChart<N,N> {
    public CustomLineChart(Axis<N> axis, Axis<N> axis1) {
        super(axis, axis1);
    }

    public CustomLineChart(Axis<N> axis, Axis<N> axis1, ObservableList<Series<N,N>> observableList) {
        super(axis, axis1, observableList);

        //this.getC

    }



}
