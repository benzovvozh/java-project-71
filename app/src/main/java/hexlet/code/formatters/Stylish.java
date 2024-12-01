package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Stylish {


    public static String format(List<Map<String, Object>> result) {
        // создаем string builder
        StringBuilder result1 = new StringBuilder("{\n");

        // обходим List
        for (Map<String, Object> item : result) {

            //получаем значение ключа type
            var type = item.get("type");
            //получаем значение ключа value1 и сразу формируем в корректную строку
            var value1 = item.get("value1").toString().replaceFirst("=", ": ")
                    .replaceFirst("\\{", "");
            var value = value1.substring(0, value1.length() - 1);


            // заполняем result1
            if (Objects.equals(type, "unchanged")) {
                result1.append("    ").append(value).append("\n");
            } else if (Objects.equals(type, "changed")) {
                //получаем значение ключа value2 и сразу формируем в корректную строку
                var valueSecondMap = item.get("value2").toString().replaceFirst("=", ": ")
                        .replaceFirst("\\{", "");
                var value2 = valueSecondMap.substring(0, valueSecondMap.length() - 1);
                result1.append("  - ").append(value).append("\n");
                result1.append("  + ").append(value2).append("\n");

            } else if (Objects.equals(type, "added")) {
                result1.append("  + ").append(value).append("\n");
            } else if (Objects.equals(type, "deleted")) {
                result1.append("  - ").append(value).append("\n");
            }
        }
        result1.append("}");
        return result1.toString();
    }
}

