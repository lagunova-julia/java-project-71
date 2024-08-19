package hexlet.code.formatters;

import hexlet.code.DataUtils;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String format(List<Map<String, Object>> comparingResult) {
        StringBuilder result = new StringBuilder();
        for (var map : comparingResult) {
            String status = (String) map.get(DataUtils.STATUS);
            switch (status) {
                case DataUtils.SAME:
                    continue;
                case DataUtils.DELETED:
                    appendDeletedProperty(result, map);
                    break;
                default:
                    appendModifiedOrAddedProperty(result, map);
                    break;
            }
        }
        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private static void appendDeletedProperty(StringBuilder result, Map<String, Object> map) {
        result.append("Property '" + map.get(DataUtils.FIELD) + "' was removed\n");
    }

    private static void appendModifiedOrAddedProperty(StringBuilder result, Map<String, Object> map) {
        result.append("Property '" + map.get(DataUtils.FIELD) + "' was");
        Object oldValue = map.get(DataUtils.OLD_VALUE);
        Object newValue = map.get(DataUtils.NEW_VALUE);

        oldValue = formatValue(oldValue);
        newValue = formatValue(newValue);

        if (map.get(DataUtils.STATUS).equals(DataUtils.CHANGED)) {
            result.append(" updated. From " + oldValue + " to " + newValue + "\n");
        } else {
            result.append(" added with value: " + newValue + "\n");
        }
    }

    private static String formatValue(Object value) {
        if (value != null && (value.getClass().isArray() || value instanceof Map<?, ?>
                || value instanceof List<?>)) {
            return "[complex value]";
        } else if (value instanceof String && !value.equals("null")) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
