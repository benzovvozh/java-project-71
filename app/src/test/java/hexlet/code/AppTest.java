
package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void call() throws Exception {
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate("file1.json", "file2.json", "stylish");
        assertEquals(expected, actual);
    }
    @Test
    void call1() throws Exception {
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String actual = Differ.generate("file1.yaml", "file2.yaml", "stylish");
        assertEquals(expected, actual);
    }


}

