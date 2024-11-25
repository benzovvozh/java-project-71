package hexlet.code.formatters;

import hexlet.code.utils.Data;
import hexlet.code.utils.Status;

import java.util.List;


public class Stylish {


    public static String format(List<Data> result) {
        // создаем string builder
        StringBuilder result1 = new StringBuilder("{\n");
        // обходим лист данных
        for (Data item : result) {
            var oldValue = item.getOldValue();
            var newValue = item.getNewValue();
            var status = item.getStatus();
            var key = item.getKey();
            // заполняем result1
            if (status.equals(Status.UNCHANGED)) {
                result1.append("    ").append(key.toString()).append(": ")
                        .append(newValue).append("\n");
            } else if (status.equals(Status.CHANGED)) {
                result1.append("  - ").append(key.toString()).append(": ")
                        .append(oldValue).append("\n")
                        .append("  + ").append(key.toString()).append(": ")
                        .append(newValue).append("\n");
            } else if (status.equals(Status.ADDED)) {
                result1.append("  + ").append(key.toString()).append(": ")
                        .append(newValue).append("\n");
            } else if (status.equals(Status.REMOVED)) {
                result1.append("  - ").append(key.toString()).append(": ")
                        .append(oldValue).append("\n");
            }


        }
        result1.append("}");
        return result1.toString();
    }
}

