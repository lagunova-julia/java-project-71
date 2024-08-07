package hexlet.code;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    private static final String JSON = "json";
    private static final String YML = "yml";
    private static final String YAML = "yaml";
    public static Map<String, Object> parse(String content, String format) throws Exception {
        Map<String, Object> map = null;
        switch (format) {
            case JSON:
                ObjectMapper objectMapper = new ObjectMapper();
                map = objectMapper.readValue(content, new TypeReference<>() {
                });
                break;
            case YML:
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                map = mapper.readValue(content, new TypeReference<>() {
                });
            case YAML:
                ObjectMapper mapperYaml = new ObjectMapper(new YAMLFactory());
                map = mapperYaml.readValue(content, new TypeReference<>() {
                });
            default:
                break;
        }

        return map;
    }
}
