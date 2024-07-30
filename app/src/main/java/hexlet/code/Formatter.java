package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> comparingResult, String format) {
        if ("stylish".equals(format)) {
            return StylishFormatter.format(comparingResult);
            // default
        } else if ("plain".equals(format)) {
            return PlainFormatter.format(comparingResult);
        } else {
            return StylishFormatter.format(comparingResult);
        }
    }
}
