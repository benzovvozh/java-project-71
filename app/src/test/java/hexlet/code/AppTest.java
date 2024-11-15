
package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static String exceptedDefault;
    private static String exceptedYamlTest;
    private static String exceptedJsonPlain;
    private static String exceptedJsonJson;
    private static String exceptedYamlPlain;
    private static String exceptedYamlJsonTest;

    @BeforeAll
    public static void beforeAll() throws IOException {

        exceptedDefault = new String(Files.readString(Paths.get("src/test/resources/callTest.txt")
                .toAbsolutePath().normalize()));
        exceptedYamlTest = new String(Files.readString(Paths.get("src/test/resources/callYamlTest.txt")
                .toAbsolutePath().normalize()));
        exceptedJsonPlain = new String(Files.readString(Paths.get("src/test/resources/callPlainTest.txt")
                .toAbsolutePath().normalize()));
        exceptedJsonJson = new String(Files.readString(Paths.get("src/test/resources/callJsonTest.txt")
                .toAbsolutePath().normalize()));
        exceptedYamlPlain = new String(Files.readString(Paths.get("src/test/resources/callPlainYamlTest.txt")
                .toAbsolutePath().normalize()));
        exceptedYamlJsonTest = new String(Files.readString(Paths.get("src/test/resources/callYamlJsonTest.txt")
                .toAbsolutePath().normalize()));
    }


    @Test
        // тест без явного указания формата (json files)
    void callNonFormatJson() throws Exception {
        String expected = exceptedDefault;
        String actual = Differ.generate("file1.json", "file2.json");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
        // тест без явного указания формата (yaml files)
    void callNonFormatYaml() throws Exception {
        String expected = exceptedYamlTest;
        String actual = Differ.generate("file1.yaml", "file2.yaml");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
        // тест yaml файлов (json)
    void callYaml() throws Exception {
        String expected = exceptedYamlJsonTest;
        String actual = Differ.generate("file1.yaml", "file2.yaml", "json");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
        // тест yaml файлов (plain)
    void callYamlPlain() throws Exception {
        String expected = exceptedYamlPlain;
        String actual = Differ.generate("file1.yaml", "file2.yaml", "plain");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
        // тест yaml файлов (stylish)
    void callYamlStylish() throws Exception {
        String expected = exceptedYamlTest;
        String actual = Differ.generate("file1.yaml", "file2.yaml", "stylish");
        assertEquals(expected.trim(), actual.trim());
    }


    @Test
        // тест plain (json files)
    void callPlainJson() throws Exception {
        String expected = exceptedJsonPlain;
        String actual = Differ.generate("file1.json", "file2.json", "plain");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
        // тест json (json files)
    void callJsonJson() throws Exception {
        String expected = exceptedJsonJson;
        String actual = Differ.generate("file1.json", "file2.json", "json");
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
        // тест stylish0 (json files)
    void callStylishJson() throws Exception {
        String expected = exceptedDefault;
        String actual = Differ.generate("file1.json", "file2.json", "stylish");
        assertEquals(expected.trim(), actual.trim());
    }


}

