package hexlet.code.formatters;

import hexlet.code.DataUtils;

import java.util.List;
import java.util.Map;

public class StylishFormatter {
    public static String format(List<Map<String, Object>> comparingResult) {
        StringBuilder result = new StringBuilder("{\n");
        Object status = null;
        for (var map : comparingResult) {
            status = map.get(DataUtils.STATUS);
            if (status.equals(DataUtils.SAME)) {
                result.append("    " + map.get(DataUtils.FIELD) + ": " + map.get(DataUtils.OLD_VALUE).toString()
                        + "\n");
            } else if (status.equals(DataUtils.CHANGED)) {
                result.append("  - " + map.get(DataUtils.FIELD) + ": " + map.get(DataUtils.OLD_VALUE).toString()
                        + "\n");
                result.append("  + " + map.get(DataUtils.FIELD) + ": " + map.get(DataUtils.NEW_VALUE).toString()
                        + "\n");
            } else if (status.equals(DataUtils.DELETED)) {
                result.append("  - " + map.get(DataUtils.FIELD) + ": " + map.get(DataUtils.OLD_VALUE).toString()
                        + "\n");
            } else {
                result.append("  + " + map.get(DataUtils.FIELD) + ": " + map.get(DataUtils.NEW_VALUE).toString()
                        + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
