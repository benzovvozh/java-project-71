
package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static String excepted1;
    private static String excepted2;
    private static String excepted3;
    private static String excepted4;

    @BeforeAll
    public static void beforeAll() throws IOException {

        excepted1 = new String(Files.readString(Paths.get("src/test/resources/callTest.txt")
                .toAbsolutePath().normalize()));
        excepted2 = new String(Files.readString(Paths.get("src/test/resources/callYamlTest.txt")
                .toAbsolutePath().normalize()));
        excepted3 = new String(Files.readString(Paths.get("src/test/resources/callPlainTest.txt")
                .toAbsolutePath().normalize()));
        excepted4 = new String(Files.readString(Paths.get("src/test/resources/callJsonTest.txt")
                .toAbsolutePath().normalize()));
    }

    @Test
    void call() throws Exception {
        String expected = excepted1;
        String actual = Differ.generate("file1.json", "file2.json", "");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
    void callYaml() throws Exception {
        String expected = excepted2;
        String actual = Differ.generate("file1.yaml", "file2.yaml", "stylish");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
    void callPlain() throws Exception {
        String expected = excepted3;
        String actual = Differ.generate("file1.json", "file2.json", "plain");
        System.out.println("Expected:\n" + expected);
        System.out.println("Actual:\n" + actual);
        assertEquals(expected.trim(), actual.trim());
    }

//    @Test
//    void callJson() throws Exception {
//        String expected = excepted4;
//        String actual = Differ.generate("file1.json", "file2.json", "json");
//        assertEquals(expected.trim(), actual.trim());
//    }


}

