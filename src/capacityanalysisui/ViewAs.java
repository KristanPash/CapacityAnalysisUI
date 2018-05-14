package capacityanalysisui;

import java.util.HashMap;
import java.util.Map;

public enum ViewAs {
    Average("Average"),
    Sum("Sum");

    private String label;

    ViewAs(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }

    private static final Map<String, ViewAs> lookup = new HashMap<>();

    static {
        for (ViewAs va : ViewAs.values())
            lookup.put(va.label, va);
    }

    public static ViewAs get (String string) {
        return lookup.get(string);
    }
}
