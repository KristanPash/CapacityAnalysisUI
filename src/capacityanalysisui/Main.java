package capacityanalysisui;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private Actions actions = new Actions();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Capacity Analysis Tool");
        // primaryStage.setFullScreen(true);

        TabPane tabPane = new TabPane();

        Tab parameterTab = new Tab();
        parameterTab.setClosable(false);
        parameterTab.setText("Simulation Parameters");
        parameterTab.setContent(createParameterPane());
        tabPane.getTabs().add(parameterTab);

        Tab ioTab = new Tab();
        ioTab.setClosable(false);
        ioTab.setText("File Input/Output");
        ioTab.setContent(createIOPane());
        tabPane.getTabs().add(ioTab);

        Tab chartTab = new Tab();
        chartTab.setClosable(false);
        chartTab.setText("Capacity Charts");
        chartTab.setContent(createChartPane());
        tabPane.getTabs().add(chartTab);

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public GridPane createParameterPane() {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Map<String, Node> map = new HashMap<>();

        // simulation/data collection dates

        Text windowTitle = new Text("Simulation windows");
        windowTitle.setFont(Font.font(18.0));
        grid.add(windowTitle,0,0, 2, 1);

        Text simTitle = new Text("Simulation:");
        grid.add(simTitle, 0,1);

        Label simStart = new Label("Start:");
        grid.add(simStart, 1, 1);

        DatePicker simStartInput = new DatePicker();
        grid.add(simStartInput, 2,1);

        map.put("plan.startDate", simStartInput);

        Label simEnd = new Label("End:");
        grid.add(simEnd, 3, 1);

        DatePicker simEndInput = new DatePicker();
        grid.add(simEndInput, 4, 1);

        map.put("plan.endDate", simEndInput);

        Text dataCollectionTitle = new Text("Data Collection:");
        grid.add(dataCollectionTitle, 0,2);

        Label dcStart = new Label("Start:");
        grid.add(dcStart, 1, 2);

        DatePicker dcStartInput = new DatePicker();
        grid.add(dcStartInput, 2, 2);

        map.put("experimentParameters.dataCollectionBeginDate", dcStartInput);

        Label dcEnd = new Label("End:");
        grid.add(dcEnd, 3, 2);

        TextField dcEndInput = new TextField();
        dcEndInput.setEditable(false);
        grid.add(dcEndInput, 4, 2);

        // student parameters

        Text studentTitle = new Text("Student parameters");
        studentTitle.setFont(Font.font(18.0));
        grid.add(studentTitle, 0, 3, 2, 1);

        Label startOfDay = new Label("Start of day:");
        grid.add(startOfDay, 0, 4);

        TextField startOfDayInput = new TextField();
        grid.add(startOfDayInput, 1, 4, 2, 1);

        map.put("ruleSet.startOfDay", startOfDayInput);

        Label startOfDayUnits = new Label("(HH:MM)");
        grid.add(startOfDayUnits, 3, 4, 2, 1);

        Label endOfDay = new Label("End of day:");
        grid.add(endOfDay, 0, 5);

        TextField endOfDayInput = new TextField();
        grid.add(endOfDayInput, 1, 5, 2, 1);

        map.put("ruleSet.endOfDay", endOfDayInput);

        Label endOfDayUnits = new Label("(HH:MM)");
        grid.add(endOfDayUnits, 3, 5, 2, 1);

        Label nightFlight = new Label("Earliest night flight:");
        grid.add(nightFlight, 0, 6);

        TextField nightFlightInput = new TextField();
        grid.add(nightFlightInput, 1, 6, 2, 1);

        map.put("ruleSet.earliestNightFlight", nightFlightInput);

        Label nightFlightUnits = new Label("(HH:MM)");
        grid.add(nightFlightUnits, 3, 6, 2, 1);
        
        Label studySpan = new Label("Max. study span:");
        grid.add(studySpan, 0, 7);

        TextField studySpanInput = new TextField();
        grid.add(studySpanInput, 1, 7, 2, 1);

        map.put("ruleSet.maximumStudentDailyMakespanHours", studySpanInput);

        Label studySpanUnits = new Label("hours");
        grid.add(studySpanUnits, 3, 7, 2, 1);

        Label dailyHours = new Label("Max. daily study:");
        grid.add(dailyHours, 0, 8);

        TextField dailyHoursInput = new TextField();
        grid.add(dailyHoursInput, 1, 8, 2, 1);

        map.put("ruleSet.maximumStudentDailyStudyHours", dailyHoursInput);

        Label dailyHoursUnits = new Label("hours");
        grid.add(dailyHoursUnits, 3, 8, 2, 1);

        Label timeOff = new Label("Min. time off overnight:");
        grid.add(timeOff, 0, 9);

        TextField timeOffInput = new TextField();
        grid.add(timeOffInput, 1, 9, 2, 1);

        map.put("ruleSet.minimumTimeOffHours", timeOffInput);

        Label timeOffUnits = new Label("hours");
        grid.add(timeOffUnits, 3, 9, 2, 1);

        // stochastic elements

        Text stochasticTitle = new Text("Stochastic parameters");
        stochasticTitle.setFont(Font.font(18.0));
        grid.add(stochasticTitle, 0, 10, 2, 1);

        Label randomSeed = new Label("Random seed:");
        grid.add(randomSeed, 0, 11);

        TextField randomSeedInput = new TextField();
        grid.add(randomSeedInput, 1, 11, 2, 1);

        map.put("general.randomSeed", randomSeedInput);

        Label illnessRate = new Label("Illness rate:");
        grid.add(illnessRate, 0, 12);

        TextField illnessRateInput = new TextField();
        grid.add(illnessRateInput, 1, 12, 2, 1);

        map.put("ruleSet.studentIllnessRate", illnessRateInput);

        Label illnessRateUnits = new Label("(between 0 and 1)");
        grid.add(illnessRateUnits, 3, 12, 2, 1);

        // prioritisation selection

        // TODO fill this in with options

        // buttons

        Button saveButton = new Button("Save parameters");
        grid.add(saveButton, 9, 20, 2, 1);

        Button loadButton = new Button("Load parameters");
        grid.add(loadButton, 9, 21, 2, 1);

        saveButton.setOnAction(e -> actions.saveParameters(map));

        loadButton.setOnAction(e -> actions.loadParameters(map));

        return grid;
    }

    public GridPane createIOPane() {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        return grid;
    }

    public GridPane createChartPane() {
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label statisticType = new Label("Statistic type");
        grid.add(statisticType, 0, 1, 2, 1);

        ComboBox statisticTypeInput = new ComboBox();
        statisticTypeInput.getItems().addAll((Object[])StatisticType.values());
        statisticTypeInput.setValue("Summary statistic");
        grid.add(statisticTypeInput, 1, 2, 2, 1);

        Label simElement = new Label("Sim element");
        grid.add(simElement, 0, 3, 2, 1);

        ComboBox simElementInput = new ComboBox();
        simElementInput.getItems().addAll(
                "Number graduated",
                "Number started",
                "Number studying",
                "Number failed",
                "Number of flights"
        );
        simElementInput.setValue("Number graduated");
        grid.add(simElementInput, 1, 4, 2, 1 );

        // add action
        statisticTypeInput.valueProperty().addListener(e ->
                actions.statisticTypeChanged(StatisticType.get(statisticTypeInput.getValue().toString()),simElementInput));

        Label viewBy = new Label("View by");
        grid.add(viewBy, 0, 5, 2, 1);

        ComboBox viewByInput = new ComboBox();
        viewByInput.getItems().addAll((Object[])ViewBy.values());
        viewByInput.setValue("Year");
        grid.add(viewByInput, 1, 6, 2, 1);

        Label viewAs = new Label("View as");
        grid.add(viewAs, 0, 7, 2, 1);

        ComboBox viewAsInput = new ComboBox();
        viewAsInput.getItems().addAll((Object[])ViewAs.values());
        viewAsInput.setValue("Average");
        grid.add(viewAsInput, 1, 8, 2, 1);

        // chart

        Pane chartPane = new Pane();
        chartPane.setMinSize(600.0, 600.0);
        grid.add(chartPane, 3, 0, 1, 10);

        // button

        Button generateButton = new Button("Generate chart");
        generateButton.setOnAction(e -> actions.createChart(
                chartPane,
                StatisticType.get(statisticTypeInput.getValue().toString()),
                simElementInput.getValue().toString(),
                ViewBy.get(viewByInput.getValue().toString()),
                ViewAs.get(viewAsInput.getValue().toString())));
        grid.add(generateButton, 1, 10, 2, 1);

        return grid;
    }
}
