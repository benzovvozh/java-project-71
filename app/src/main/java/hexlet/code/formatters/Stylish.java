package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {


    public static String format(List<Map<String, Object>> result) {
        // создаем string builder
        StringBuilder result1 = new StringBuilder("{\n");

        // обходим List
        for (Map<String, Object> item : result) {

            // получаем ключ added/deleted/change (correct)
            String keyFromList = item.keySet().iterator().next();
            System.out.println(keyFromList);
            // получаем Map<String, Object> (correct)
            Map<String, Object> map = (Map<String, Object>) item.get(keyFromList);
            System.out.println(map);
            // получаем ключ из map (correct)
            String mapKey = map.keySet().iterator().next();
            System.out.println(mapKey);
            // получаем значение из map
            var value = map.get(mapKey);
            System.out.println(value);
            // заполняем result1
            if (item.containsKey("unchanged")) {
                result1.append("    ").append(mapKey).append(": ")
                        .append(value).append("\n");
            } else if (item.containsKey("change-")) {
                result1.append("  - ").append(mapKey).append(": ")
                        .append(value).append("\n");
            } else if (item.containsKey("change+")) {
                result1.append("  + ").append(mapKey).append(": ")
                        .append(value).append("\n");
            } else if (item.containsKey("added")) {
                result1.append("  + ").append(mapKey).append(": ")
                        .append(value).append("\n");
            } else if (item.containsKey("deleted")) {
                result1.append("  - ").append(mapKey).append(": ")
                        .append(value).append("\n");
            }
        }
        result1.append("}");
        return result1.toString();
    }
}

