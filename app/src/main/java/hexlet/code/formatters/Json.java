package hexlet.code.formatters;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<String, Object>> result) throws Exception {
        ObjectMapper mapperJson = new ObjectMapper();

        return mapperJson.writeValueAsString(formattedList(result));
    }

    public static List<Map<String, Object>> formattedList(List<Map<String, Object>> result) throws Exception {
        List<Map<String, Object>> formatted = new ArrayList<>();
        for (Map<String, Object> item : result) {
            Map<String, Object> map = new LinkedHashMap<>();
            // обходим каждую мапу
            // перебираем каждую пару ключ-значение в карте
            for (Map.Entry<String, Object> entry : item.entrySet()) {
                var key = entry.getKey();
                var value = entry.getValue();
                String formattedKey = key.substring(3);
                map.put(formattedKey, value);
            }
            formatted.add(map);
        }

        return formatted;
    }
}
