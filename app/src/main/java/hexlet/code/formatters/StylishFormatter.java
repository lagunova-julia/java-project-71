package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String format(List<Map<String, Object>> comparingResult) {
        StringBuilder result = new StringBuilder("{\n");
        Object status = null;
        for (var map : comparingResult) {
            status = map.get("STATUS");
            if (status.equals("SAME")) {
                result.append("    " + map.get("FIELD") + ": " + map.get("OLD_VALUE").toString() + "\n");
            } else if (status.equals("CHANGED")) {
                result.append("  - " + map.get("FIELD") + ": " + map.get("OLD_VALUE").toString() + "\n");
                result.append("  + " + map.get("FIELD") + ": " + map.get("NEW_VALUE").toString() + "\n");
            } else if (status.equals("DELETED")) {
                result.append("  - " + map.get("FIELD") + ": " + map.get("OLD_VALUE").toString() + "\n");
            } else {
                result.append("  + " + map.get("FIELD") + ": " + map.get("NEW_VALUE").toString() + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
