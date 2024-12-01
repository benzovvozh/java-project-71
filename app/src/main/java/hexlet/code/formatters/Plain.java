package hexlet.code.formatters;


import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        for (var item : result) {

            var type = item.get("type");

            Map<String, Object> value = (Map<String, Object>) item.get("value1");
            var key1 = value.keySet();
            var key = key1.toString().replace("[", "").replace("]", "");

            var value1 = value.get(key);

            // если было изменение
            if (Objects.equals(type, "changed")) {
                //создаем старое значение
                Map<String, Object> value22 = (Map<String, Object>) item.get("value2");
                var value2 = value22.get(key);
                // собираем строку
                result1.append(property)
                        .append(key)
                        .append(update)
                        .append(" From ")
                        .append(form(value1))
                        .append(" to ")
                        .append(form(value2))
                        .append("\n");
                //если было удалено
            } else if (Objects.equals(type, "deleted")) {
                result1.append(property)
                        .append(key)
                        .append(remove)
                        .append("\n");
                //если было добавлено
            } else if (Objects.equals(type, "added")) {

                result1.append(property)
                        .append(key)
                        .append(add)
                        .append(form(value1))
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
