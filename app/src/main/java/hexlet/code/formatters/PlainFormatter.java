package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String format(List<Map<String, Object>> comparingResult) {

        StringBuilder result = new StringBuilder();
        Object status = "";

        for (var map : comparingResult) {
            status = map.get("STATUS");

            if (status.equals("SAME")) {
                result.append("");
            } else {
                result.append("Property '" + map.get("FIELD") + "' was ");

                if (status.equals("DELETED")) {
                    result.append("removed\n");
                } else {

                    Object oldValue = map.get("OLD_VALUE");
                    Object newValue = map.get("NEW_VALUE");

                    // проверка на вложенные структуры и строки
                    if (oldValue != null && (oldValue.getClass().isArray() || oldValue instanceof Map<?, ?>
                            || oldValue instanceof List<?>)) {
                        oldValue = "[complex value]";
                    } else if (oldValue instanceof String && !oldValue.equals("null")) {
                        oldValue = "'" + oldValue + "'";
                    }

                    if (newValue != null && (newValue.getClass().isArray() || newValue instanceof Map<?, ?>
                            || newValue instanceof List<?>)) {
                        newValue = "[complex value]";
                    } else if (newValue instanceof String && !newValue.equals("null")) {
                        newValue = "'" + newValue + "'";
                    }

                    if (status.equals("CHANGED")) {
                        result.append("updated. From " + oldValue + " to " + newValue + "\n");
                    } else {
                        result.append("added with value: " + newValue + "\n");
                    }
                }
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();

    }
}
