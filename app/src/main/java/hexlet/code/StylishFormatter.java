package hexlet.code;

import java.util.List;
import java.util.Map;


public class StylishFormatter {
    public static String format(List<Map<String, Object>> result) {
        StringBuilder result1 = new StringBuilder("{\n");
        for (Map<String, Object> item : result) {
            // Перебираем каждую пару ключ-значение в карте
            for (Map.Entry<String, Object> entry : item.entrySet()) {
                result1.append("  ").append(entry.getKey()).append(": ")
                        .append(entry.getValue()).append("\n");
            }
        }
        result1.append("}");
        return result1.toString();
    }
}

