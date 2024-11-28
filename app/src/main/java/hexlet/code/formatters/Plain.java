package hexlet.code.formatters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String format(List<Map<String, Object>> result) {
        // создаем строки для упрощения создания отчета
        String property = "Property '";
        String update = "' was updated.";
        String add = "' was added with value: ";
        String remove = "' was removed";

        // создаем StringBuilder
        StringBuilder result1 = new StringBuilder();

        // обходим List
        for (int i = 0; i < result.size(); i++) {
            Map<String, Object> item = new HashMap<>(result.get(i));
            // получаем ключ added/deleted/change+- (correct)
            String keyFromList = item.keySet().iterator().next();

            // получаем Map<String, Object> (correct)
            Map<String, Object> map = (Map<String, Object>) item.get(keyFromList);

            // получаем ключ из map (correct)
            String mapKey = map.keySet().iterator().next();

            // получаем значение из map
            var value = map.get(mapKey);
            // если было изменение
            if (item.containsKey("change+")) {
                //создаем объект - старое значение
                Object oldValue = null;
                if (i > 0 && result.get(i - 1).containsKey("change-")) {
                    Map<String, Object> bigMap = result.get(i - 1); // change- : fruit: apple
                    Map<String, Object> miniMap = (Map<String, Object>) bigMap.get("change-"); // fruit: apple
                    oldValue = miniMap.get(mapKey); // apple
                }
                // собираем строку
                result1.append(property)
                        .append(mapKey)
                        .append(update)
                        .append(" From ")
                        .append(form(oldValue))
                        .append(" to ")
                        .append(form(value))
                        .append("\n");
                //если было удалено
            } else if (item.containsKey("deleted")) {
                result1.append(property)
                        .append(mapKey)
                        .append(remove)
                        .append("\n");
                //если было добавлено
            } else if (item.containsKey("added")) {
                result1.append(property)
                        .append(mapKey)
                        .append(add)
                        .append(form(value))
                        .append("\n");
            }
        }
        //удаляем последний лишний символ в строке (\n)
        result1.deleteCharAt(result1.length() - 1);
        return result1.toString();
    }

    private static Object form(Object value) {
        if (value == null || value.equals("null")) {
            return "null"; // Обработка null значений
        } else if (value instanceof String) {
            return "'" + value + "'"; // Обрамляем строку кавычками
        } else if (value instanceof Boolean || value instanceof Integer) {
            return value; // Возвращаем булево или целочисленное значение как есть
        } else {
            return "[complex value]"; // Для всех остальных типов
        }
    }
}
