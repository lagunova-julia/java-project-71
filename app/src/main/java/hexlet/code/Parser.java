package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    public static Map<String, Object> getData(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(content, new TypeReference<>(){});
        return map;
    }
}
//ObjectMapper здесь вместо отдельного метода parse()
