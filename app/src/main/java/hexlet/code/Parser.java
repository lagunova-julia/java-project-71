package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    public static Map<String, Object> getData(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(content, new TypeReference<>() { });
        return map;
    }

    public static Map<String, Object> getDataYaml(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> map = mapper.readValue(content, new TypeReference<>() { });
        return map;
    }
}
//ObjectMapper здесь вместо отдельного метода parse()
