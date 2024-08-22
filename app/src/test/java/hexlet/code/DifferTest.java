package hexlet.code;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DifferTest {
    private final String invalidJsonData = "invalid json data";
    private final String invalidYamlData = "invalid yaml data";
    private final String invalidYmlData = "invalid yml data";
    private String expectedStylishPath;
    private String expectedPlainPath;
    private String expectedJsonPath;
    private String result;
    private String format;
    private String expectedOutput;

    @BeforeEach
    void initEach() {
        expectedStylishPath = "src/test/resources/expected/stylish.txt";
        expectedPlainPath = "src/test/resources/expected/plain.txt";
        expectedJsonPath = "src/test/resources/expected/json.txt";
    }

    @Test
    public void testInvalidJsonParsing() {
        assertThrows(JsonParseException.class, () -> {
            Parser.parse(invalidJsonData, "json");
        }, "JsonParseException was expected");
    }

    @Test
    public void testInvalidYamlParsing() {
        assertThrows(JsonMappingException.class, () -> {
            Parser.parse(invalidYamlData, "yaml");
        }, "JsonMappingException was expected");
    }

    @Test
    public void testInvalidYmlParsing() {
        assertThrows(JsonMappingException.class, () -> {
            Parser.parse(invalidYmlData, "yml");
        }, "JsonMappingException was expected");
    }

    @ParameterizedTest
    @CsvSource({
        "src/test/resources/file1.json, src/test/resources/file2.json",
        "src/test/resources/file1.yml, src/test/resources/file2.yml"
    })
    void testDefaultOutput(String filePath1, String filePath2) throws Exception {
        expectedOutput = DataUtils.readFixedPath(expectedStylishPath);
        result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest
    @CsvSource({
        "src/test/resources/file1.json, src/test/resources/file2.json",
        "src/test/resources/file1.yml, src/test/resources/file2.yml"
    })
    void testStylishOutput(String filePath1, String filePath2) throws Exception {
        format = "stylish";
        expectedOutput = DataUtils.readFixedPath(expectedStylishPath);
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest
    @CsvSource({
        "src/test/resources/file1.json, src/test/resources/file2.json",
        "src/test/resources/file1.yml, src/test/resources/file2.yml"
    })
    void testPlainOutput(String filePath1, String filePath2) throws Exception {
        format = "plain";
        expectedOutput = DataUtils.readFixedPath(expectedPlainPath);
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest
    @CsvSource({
        "src/test/resources/file1.json, src/test/resources/file2.json",
        "src/test/resources/file1.yml, src/test/resources/file2.yml"
    })
    void testJsonOutput(String filePath1, String filePath2) throws Exception {
        format = "json";
        expectedOutput = DataUtils.readFixedPath(expectedJsonPath);
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest
    @CsvSource({
        "src/test/resources/file1.json, src/test/resources/file2.json",
        "src/test/resources/file1.yml, src/test/resources/file2.yml"
    })
    void testIncorrectResult(String filePath1, String filePath2) throws Exception {
        expectedOutput = DataUtils.readFixedPath(expectedPlainPath);
        result = Differ.generate(filePath1, filePath2);
        assertNotEquals(expectedOutput, result);
    }
}
