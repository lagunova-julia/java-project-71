package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DifferTest {
    private String filePathJson1 = "src/test/resources/file1.json";
    private String filePathJson2 = "src/test/resources/file2.json";
    private String filePathYml1 = "src/test/resources/file1.yml";
    private String filePathYml2 = "src/test/resources/file2.yml";
    private String expectedStylishPath = "src/test/resources/expected/stylish.txt";
    private String expectedPlainPath = "src/test/resources/expected/plain.txt";
    private String expectedJsonPath = "src/test/resources/expected/json.txt";
    private String result;
    private String format;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testInvalidJsonParsing() {
        String invalidJsonData = "invalid json data";
        try {
            Parser.parse(invalidJsonData, "json");
            fail("Trying to parse invalid json file");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidYamlParsing() {
        String invalidYamlData = "invalid yaml data";
        try {
            Parser.parse(invalidYamlData, "yaml");
            fail("Trying to parse invalid yaml file");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidYmlParsing() {
        String invalidYmlData = "invalid yml data";
        try {
            Parser.parse(invalidYmlData, "yml");
            fail("Trying to parse invalid yml file");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testDefaultOutput() throws Exception {
        String expectedStylish = DataUtils.readFixedPath(expectedStylishPath);
        result = Differ.generate(filePathJson1, filePathJson2);
        assertEquals(expectedStylish, result);

        result = Differ.generate(filePathYml1, filePathYml2);
        assertEquals(expectedStylish, result);
    }

    @Test
    void testStylishOutput() throws Exception {
        format = "stylish";
        String expectedStylish = DataUtils.readFixedPath(expectedStylishPath);
        result = Differ.generate(filePathJson1, filePathJson2, format);
        assertEquals(expectedStylish, result);

        result = Differ.generate(filePathYml1, filePathYml2, format);
        assertEquals(expectedStylish, result);
    }

    @Test
    void testPlainOutput() throws Exception {
        format = "plain";
        String expectedPlain = DataUtils.readFixedPath(expectedPlainPath);
        result = Differ.generate(filePathJson1, filePathJson2, format);
        assertEquals(expectedPlain, result);

        result = Differ.generate(filePathYml1, filePathYml2, format);
        assertEquals(expectedPlain, result);
    }

    @Test
    void testJsonOutput() throws Exception {
        format = "json";
        String expectedJson = DataUtils.readFixedPath(expectedJsonPath);
        result = Differ.generate(filePathJson1, filePathJson2, format);
        assertEquals(expectedJson, result);

        result = Differ.generate(filePathYml1, filePathYml2, format);
        assertEquals(expectedJson, result);
    }

    @Test
    void testIncorrectResult() throws Exception {
        String expectedPlain = DataUtils.readFixedPath(expectedPlainPath);
        result = Differ.generate(filePathJson1, filePathJson2);
        assertNotEquals(expectedPlain, result);

        result = Differ.generate(filePathYml1, filePathYml2);
        assertNotEquals(expectedPlain, result);
    }
}
