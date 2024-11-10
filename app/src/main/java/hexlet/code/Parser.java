package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.util.HashMap;
import java.util.Map;


public class Parser {
    public static Map<String, Object> parse(String content, String format) throws Exception {
        // парсим файл

        Map<String, Object> map = new HashMap<>();
        if (format.equals("json")) {
            ObjectMapper mapperJson = new ObjectMapper();
            map = mapperJson.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        } else if (format.equals("yaml")) {
            ObjectMapper mapperYaml = new YAMLMapper();
            map = mapperYaml.readValue(content, new TypeReference<Map<String, Object>>() {
            });

        }




        return map;
    }
}
