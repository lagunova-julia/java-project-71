package hexlet.code;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String format(List<Map<String, Object>> comparingResult) {
        // какой формат выдачи результата сравнения

        StringBuilder result = new StringBuilder("{\n");
        Object status = null;
        for (var map : comparingResult) {
            status = map.get("STATUS");
            if (status.equals("SAME")) {
                result.append("    " + map.get("FIELD") + ": " + map.get("OLD_VALUE") + "\n");
            } else if (status.equals("CHANGED")) {
                result.append("  - " + map.get("FIELD") + ": " + map.get("OLD_VALUE") + "\n");
                result.append("  + " + map.get("FIELD") + ": " + map.get("NEW_VALUE") + "\n");
            } else if (status.equals("DELETED")) {
                result.append("  - " + map.get("FIELD") + ": " + map.get("OLD_VALUE") + "\n");
            } else {
                result.append("  + " + map.get("FIELD") + ": " + map.get("NEW_VALUE") + "\n");
            }
        }
        result.append("}");
        return result.toString();

    }
}
