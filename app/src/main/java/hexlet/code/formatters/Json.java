package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<String, Object>> result) throws Exception {

        ObjectMapper mapperJson = new ObjectMapper();
        List<Map<String, Object>> result1 = new ArrayList<>();

        for (var item : result) {
            // получаем ключ added/deleted/change (correct)
            String keyFromList = item.keySet().iterator().next();

            // получаем Map<String, Object> (correct)
            Map<String, Object> map = (Map<String, Object>) item.get(keyFromList);
            result1.add(map);
        }
        var some = mapperJson.writeValueAsString(result1)
                .replace("{", "").replace("}","");
        var some1 = "[{" + some.substring(1, some.length()-1) + "}]";
        // не закончен

        return some1;
    }
}
