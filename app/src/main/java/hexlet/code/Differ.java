package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {




    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = readFile(filepath1);
        String content2 = readFile(filepath2);

        String fileType1 = getFileType(filepath1);
        String fileType2 = getFileType(filepath2);

        var file1 = Parser.parse(content1, fileType1);
        var file2 = Parser.parse(content2, fileType2);

        List<Map<String, Object>> result = MapComparator.compare(file1, file2);
        return StylishFormatter.format(result);
    }

    private static String readFile(String filepath) throws Exception {

        String readFilePath = "src/test/resources/" + filepath;
        Path path = Paths.get(readFilePath).toAbsolutePath().normalize();
        // Проверяем существование файла
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        // Читаем файл
        String content = Files.readString(path);

        return content;
    }

    private static String getFileType(String filepath) {
        // возвращает расширение файла (json, yml, yaml)
        // сплитим по точке и берем последний элемент массива
        String readFilePath = "src/test/resources/" + filepath;
        String[] words = readFilePath.split("\\.");
        String fileType = words[words.length - 1];
        return fileType;
    }
}