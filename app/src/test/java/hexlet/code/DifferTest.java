package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private String filePath1;
    private String filePath2;
    private String expected;
    private String result;

    @BeforeEach
    void setUp() {
    }

    @Test
    void generate() throws Exception {
        filePath1 = "src/test/resources/filepath1.json";
        filePath2 = "src/test/resources/filepath2.json";
        expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        result = Differ.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }
}
