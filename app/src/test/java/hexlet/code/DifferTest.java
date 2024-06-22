package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DifferTest {

    private String expected;
    private String result;

    @BeforeEach
    void setUp() {
    }

    @Test
    void generate() throws Exception {
        assertTrue(true);

        expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        result = Differ.generate("filepath1.json", "filepath2.json");
        assertEquals(expected, result);
    }
}
