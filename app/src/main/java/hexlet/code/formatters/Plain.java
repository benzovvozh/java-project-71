package hexlet.code.formatters;

import hexlet.code.utils.Data;
import hexlet.code.utils.Status;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plain {

    public static String format(List<Map<String, Object>> result) {
        String property = "Property '";
        String upd = "' was updated.";
        String add = "' was added with value: ";
        String rem = "' was removed";

        StringBuilder result1 = new StringBuilder();
        // обходим данные
        for (Map<String, Object> item : result) {
            String key = item.keySet().iterator().next();// added/deleted/change
            var value = item.get(key); //Map<String, Object> ..;


            if (item.containsKey("deleted")) { // equlas " "
                result1.append(property)
                        .append(key)
                        .append(upd)
                        .append(" From ")
                        .append(form(value))
                        .append(" to ")
                        .append(value)
                        .append("\n");
            } else if (item.containsKey("deleted")) { //eqauls "-"
                result1.append(property)
                        .append(key)
                        .append(rem)
                        .append("\n");
            } else if (item.containsKey("added")) { // equals "+"
                result1.append(property)
                        .append(key)
                        .append(add)
                        .append(form(value))
                        .append("\n");
            }
        }

        result1.deleteCharAt(result1.length() - 1);
        return result1.toString();
    }

    private static Object form(Object value) {
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
