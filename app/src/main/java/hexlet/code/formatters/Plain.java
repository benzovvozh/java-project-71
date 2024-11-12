package hexlet.code.formatters;


import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> result) {
        String property = "Property '";
        String upd = "' was updated.";
        String add = "' was added with value: ";
        String rem = "' was removed";

        StringBuilder result1 = new StringBuilder();
        // обходим лист мап
        for (Map<String, Object> item : result) {
            // обходим каждую мапу
            // перебираем каждую пару ключ-значение в карте
            for (Map.Entry<String, Object> entry : item.entrySet()) {

                String key = entry.getKey();
                Object value = entry.getValue();
                String realKey = key.substring(3);
                var replacedKey = key.replace("up+", "up-");


                if (key.startsWith("up+")) {
                    var oldValue = item.get(replacedKey);


                    result1.append(property)
                            .append(realKey)
                            .append(upd)
                            .append(" From ")
                            .append(form(oldValue))
                            .append(" to ")
                            .append(form(value))
                            .append("\n");
                } else if (key.startsWith("del")) {
                    result1.append(property)
                            .append(realKey)
                            .append(rem)
                            .append("\n");
                } else if (key.startsWith("add")) {
                    result1.append(property)
                            .append(realKey)
                            .append(add)
                            .append(form(value))
                            .append("\n");
                }


            }

        }

        return result1.toString();
    }

    public static Object form(Object value) {
        if (value == null || value.equals("null")) {
            return "null"; // Обработка null значений
        } else if (value instanceof String) {
            return "'" + value + "'"; // Обрамляем строку кавычками
        } else if (value instanceof Boolean || value instanceof Integer) {
            return value; // Возвращаем булевое или целочисленное значение как есть
        } else {
            return "[complex value]"; // Для всех остальных типов
        }
    }
}
