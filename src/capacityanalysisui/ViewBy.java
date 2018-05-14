package capacityanalysisui;

import java.util.HashMap;
import java.util.Map;

public enum ViewBy {
    Day("Day"),
    Week("Week"),
    Month("Month"),
    Year("Year");

    private String label;

    ViewBy(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
    private static final Map<String, ViewBy> lookup = new HashMap<>();

    static {
        for (ViewBy vb : ViewBy.values())
            lookup.put(vb.label, vb);
    }

    public static ViewBy get (String string) {
        return lookup.get(string);
    }
}
