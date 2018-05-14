package capacityanalysisui;

import java.util.HashMap;
import java.util.Map;

public enum StatisticType {
    SummaryStatistic("Summary statistic"),
    StudentTrainingTime("Student training time"),
    ResourceAvailability("Resource availability"),
    ResourceUse("Resource use");

    private String label;

    StatisticType(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }

    private static final Map<String, StatisticType> lookup = new HashMap<>();

    static {
        for (StatisticType st : StatisticType.values())
            lookup.put(st.label, st);
    }

    public static StatisticType get (String string) {
        return lookup.get(string);
    }
}
