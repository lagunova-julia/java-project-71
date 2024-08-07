package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {
    private static final String DEFAULT_FORMAT = "stylish";

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = DataUtils.readFixedPath(filepath1);
        String content2 = DataUtils.readFixedPath(filepath2);

        String fileFormat1 = DataUtils.getFileType(filepath1);
        String fileFormat2 = DataUtils.getFileType(filepath2);

        Map<String, Object> file1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> file2 = Parser.parse(content2, fileFormat2);

        List<Map<String, Object>> comparingResult = Comparison.compare(file1, file2);

        return Formatter.format(comparingResult, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, DEFAULT_FORMAT);
    }
}

