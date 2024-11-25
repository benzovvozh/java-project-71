package hexlet.code.formatters;

import hexlet.code.utils.Data;
import hexlet.code.utils.Status;

import java.util.List;

public class Plain {

    public static String format(List<Data> result) {
        String property = "Property '";
        String upd = "' was updated.";
        String add = "' was added with value: ";
        String rem = "' was removed";

        StringBuilder result1 = new StringBuilder();
        // обходим данные
        for (Data item : result) {
            var oldValue = item.getOldValue();
            var newValue = item.getNewValue();
            var status = item.getStatus();
            var key = item.getKey();


            if (status.equals(Status.CHANGED)) {

                result1.append(property)
                        .append(key)
                        .append(upd)
                        .append(" From ")
                        .append(form(oldValue))
                        .append(" to ")
                        .append(form(newValue))
                        .append("\n");
            } else if (status.equals(Status.REMOVED)) {
                result1.append(property)
                        .append(key)
                        .append(rem)
                        .append("\n");
            } else if (status.equals(Status.ADDED)) {
                result1.append(property)
                        .append(key)
                        .append(add)
                        .append(form(newValue))
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
