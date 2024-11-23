package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> differences, String formatName) throws Exception {

        return switch (formatName) {

            case "json" -> Json.format(differences);
            case "stylish" -> Stylish.format(differences);
            case "plain" -> Plain.format(differences);
            default -> throw new Exception("Unknown format: '" + formatName + "'");
        };
    }
}

