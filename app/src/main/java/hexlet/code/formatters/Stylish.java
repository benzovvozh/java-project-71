package hexlet.code.formatters;


import java.util.List;
import java.util.Map;


public class Stylish {
    private static final int INDEX = 3;

    public static String format(List<Map<String, Object>> result) {
        StringBuilder result1 = new StringBuilder("{\n");
        // обходим лист мап
        for (Map<String, Object> item : result) {
            // обходим каждую мапу
            // перебираем каждую пару ключ-значение в карте
            for (Map.Entry<String, Object> entry : item.entrySet()) {
                var value = entry.getKey();
                if (value.toString().startsWith("not")) {
                    result1.append("    ").append(entry.getKey().toString().substring(INDEX)).append(": ")
                            .append(entry.getValue()).append("\n");
                } else if (value.toString().startsWith("del")) {
                    result1.append("  - ").append(entry.getKey().toString().substring(INDEX)).append(": ")
                            .append(entry.getValue()).append("\n");
                } else if (value.toString().startsWith("add")) {
                    result1.append("  + ").append(entry.getKey().toString().substring(INDEX)).append(": ")
                            .append(entry.getValue()).append("\n");
                } else if (value.toString().startsWith("up-")) {
                    result1.append("  - ").append(entry.getKey().toString().substring(INDEX)).append(": ")
                            .append(entry.getValue()).append("\n");
                } else if (value.toString().startsWith("up+")) {
                    result1.append("  + ").append(entry.getKey().toString().substring(INDEX)).append(": ")
                            .append(entry.getValue()).append("\n");
                }


            }
        }
        result1.append("}");
        return result1.toString();
    }
}

