package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private String filePath1;
    private String filePath2;
    private String expectedStylish;
    private String expectedPlain;
    private String expectedJson;
    private String result;
    private String format;

    @BeforeEach
    void setUp() {
    }

    @Test
    void generate() throws Exception {
        filePath1 = "src/test/resources/file1.json";
        filePath2 = "src/test/resources/file2.json";
        expectedStylish = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedStylish, result);

        format = "plain";
        expectedPlain = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedPlain, result);

        filePath1 = "src/test/resources/file1.yml";
        filePath2 = "src/test/resources/file2.yml";
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedPlain, result);

        format = "stylish";
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedStylish, result);

        format = "json";
        expectedJson = "[{\"STATUS\":\"SAME\",\"FIELD\":\"chars1\",\"OLD_VALUE\":[\"a\",\"b\",\"c\"]},"
                + "{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":false,\"FIELD\":\"chars2\",\"OLD_VALUE\":[\"d\",\"e\",\"f\"]},"
                + "{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":true"
                + ",\"FIELD\":\"checked\",\"OLD_VALUE\":false},{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":[\"value1\","
                + "\"value2\"],\"FIELD\":\"default\",\"OLD_VALUE\":\"null\"},{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":"
                + "\"null\",\"FIELD\":\"id\","
                + "\"OLD_VALUE\":45},{\"STATUS\":\"DELETED\",\"FIELD\":\"key1\",\"OLD_VALUE\":\"value1\"},{\"STATUS\":"
                + "\"ADDED\",\"NEW_VALUE\":\"value2\",\"FIELD\":\"key2\"},{\"STATUS\":\"SAME\",\"FIELD\":\"numbers1\","
                + "\"OLD_VALUE\":[1,2"
                + ",3,4]},{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":[22,33,44,55],\"FIELD\":\"numbers2\",\"OLD_VALUE\":"
                + "[2,3,4,5]},{\"STATUS\":\"DELETED\",\"FIELD\":\"numbers3\",\"OLD_VALUE\":[3,4,5]},{\"STATUS\":"
                + "\"ADDED\",\"NEW_VA"
                + "LUE\":[4,5,6],\"FIELD\":\"numbers4\"},{\"STATUS\":\"ADDED\",\"NEW_VALUE\":{\"nestedKey\":\"value\","
                + "\"isNested\":true},\"FIELD\":\"obj1\"},{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":\"Another value\","
                + "\"FIELD\":\"settin"
                + "g1\",\"OLD_VALUE\":\"Some value\"},{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":300,\"FIELD\":\"setting2\","
                + "\"OLD_VALUE\":200},{\"STATUS\":\"CHANGED\",\"NEW_VALUE\":\"none\",\"FIELD\":\"setting3\","
                + "\"OLD_VALUE\":true}]";
        result = Differ.generate(filePath1, filePath2, format);
        assertEquals(expectedJson, result);
    }
}
