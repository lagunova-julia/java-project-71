package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    // добавить в метод String format, и внутри метода уже идет выбор, какой формат парсит
    // в один метод эти 2 объединить
    public static Map<String, Object> parse(String content, String format) throws Exception {
        Map<String, Object> map = null;
        switch (format) {
            case "json":
                ObjectMapper objectMapper = new ObjectMapper();
                map = objectMapper.readValue(content, new TypeReference<>() {
                });
                break;
            case "yml":
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                map = mapper.readValue(content, new TypeReference<>() {
                });
        }

        return map;
    }
}
