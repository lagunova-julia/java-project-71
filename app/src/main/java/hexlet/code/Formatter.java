package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> comparingResult, String format) throws JsonProcessingException {
        if ("stylish".equals(format)) {
            return StylishFormatter.format(comparingResult);
            // default
        } else if ("plain".equals(format)) {
            return PlainFormatter.format(comparingResult);
        } else if ("json".equals(format)) {
            return JsonFormatter.format(comparingResult);
        } else {
            return StylishFormatter.format(comparingResult);
        }
    }
}
