package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        // чтение файлов
        String content1 = DataUtils.readFixedPath(filepath1);
        String content2 = DataUtils.readFixedPath(filepath2);

        // определение формата(расширения) файла
        String fileFormat1 = DataUtils.getFileType(filepath1);
        String fileFormat2 = DataUtils.getFileType(filepath2);

        // парсинг файлов (превращение в Map<String, Object>)
        Map<String, Object> file1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> file2 = Parser.parse(content2, fileFormat2);

        // сравнение файлов
        List<Map<String, Object>> comparingResult = Comparison.compare(file1, file2);

        // выдача результата в нужном формате
        return Formatter.format(comparingResult, format);

    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}

