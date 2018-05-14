package capacityanalysisui;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Actions {

    public void createChart(Pane chartPane, StatisticType type, String element, ViewBy viewBy, ViewAs viewAs) {

        chartPane.getChildren().clear();

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);

        XYChart.Series series = new XYChart.Series();

        Random random = new Random();
        int numValues = random.nextInt(100);

        for(int i = 0; i< numValues; i++) {
            series.getData().add(new XYChart.Data("Thing " + i, random.nextInt(200)));
        }

        bc.getData().add(series);

        bc.setPrefSize(600, 600);
        bc.setTitle(type.toString() + " " + element + " " + viewBy.toString() + " " + viewAs.toString());

        chartPane.getChildren().add(bc);

        return;
    }

    public void statisticTypeChanged(StatisticType st, ComboBox cb) {

        if (st.equals(StatisticType.SummaryStatistic)) {
            cb.getItems().clear();
            cb.getItems().addAll(
                    "Number graduated",
                    "Number started",
                    "Number studying",
                    "Number failed",
                    "Number of flights"
            );
            cb.setValue("Number graduated");
        }
        if (st.equals(StatisticType.StudentTrainingTime)) {
            cb.getItems().clear();
            cb.getItems().addAll(
                    "Pilot",
                    "AvWO",
                    "Senso"
            );
            cb.setValue("Pilot");
        }
        if (st.equals(StatisticType.ResourceAvailability) || st.equals(StatisticType.ResourceUse)) {
            cb.getItems().clear();
            cb.getItems().addAll(
                    "Aircraft",
                    "Static",
                    "BROMEO",
                    "CMT",
                    "DRN",
                    "JMPS",
                    "OFT",
                    "WTT",
                    "PTT",
                    "LSO LAB",
                    "AvWI A",
                    "AvWI B",
                    "AvWI C"
            );
            cb.setValue("Aircraft");
        }
    }
}
