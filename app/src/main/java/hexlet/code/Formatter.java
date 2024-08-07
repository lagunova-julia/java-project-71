package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> comparingResult, String format)
            throws Exception {
        switch (format) {
            case "stylish":
                return StylishFormatter.format(comparingResult);
            case "plain":
                return PlainFormatter.format(comparingResult);
            case "json":
                return JsonFormatter.format(comparingResult);
            default:
                throw new Exception("Unknown format: '" + format + "'");
        }
    }
}
