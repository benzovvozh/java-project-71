package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class Parser {
    public static Map<String, Object> parse(String content, String format) throws Exception {
        // парсим файл
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });

        return map;
    }
}
