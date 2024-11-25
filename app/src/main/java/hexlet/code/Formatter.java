package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.utils.Data;
import java.util.List;


public class Formatter {
    public static String format(List<Data> differences, String formatName) throws Exception {

        return switch (formatName) {

            case "json" -> Json.format(differences);
            case "stylish" -> Stylish.format(differences);
            case "plain" -> Plain.format(differences);
            default -> throw new Exception("Unknown format: '" + formatName + "'");
        };
    }
}

