package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.List;
import java.util.Map;

public class Formatter {
    private static final String STYLISH = "stylish";
    private static final String PLAIN = "plain";
    private static final String JSON = "json";

    public static String format(List<Map<String, Object>> comparingResult, String format)
            throws Exception {
        switch (format) {
            case STYLISH:
                return StylishFormatter.format(comparingResult);
            case PLAIN:
                return PlainFormatter.format(comparingResult);
            case JSON:
                return JsonFormatter.format(comparingResult);
            default:
                throw new Exception("Unknown format: '" + format + "'");
        }
    }
}
