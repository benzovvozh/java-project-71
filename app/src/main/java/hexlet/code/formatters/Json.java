package hexlet.code.formatters;


import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.utils.Data;
import hexlet.code.utils.Status;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Json {


    public static String format(List<Data> result) throws Exception {
        ObjectMapper mapperJson = new ObjectMapper();

        return mapperJson.writeValueAsString(formattedList(result));
    }

    public static List<Map<String, Object>> formattedList(List<Data> result) throws Exception {
        List<Map<String, Object>> formatted = new ArrayList<>();
        Map<String, Object> map = new LinkedHashMap<>();
        // обходим объекты
        for (Data item : result) {
            if (item.getStatus().equals(Status.ADDED)) {
                map.put(item.getKey(), item.getNewValue());
            } else if (item.getStatus().equals(Status.CHANGED)) {
                map.put(item.getKey(), item.getOldValue());
                map.put(item.getKey(), item.getNewValue());
            } else if (item.getStatus().equals(Status.REMOVED)) {
                map.put(item.getKey(), item.getOldValue());
            } else {
                map.put(item.getKey(), item.getNewValue());
            }
        }
        formatted.add(map);
        return formatted;
    }
}
