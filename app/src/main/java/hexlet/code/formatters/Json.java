package hexlet.code.formatters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<String, Object>> result) throws Exception {
        ObjectMapper mapperJson = new ObjectMapper();

        // Используем LinkedHashMap для хранения всех объединенных данных
        Map<String, Object> combinedMap = new LinkedHashMap<>();

        // Обрабатываем каждый элемент списка
        for (var item : result) {
            var type = item.get("type");

            // Добавляем значения в зависимости от типа
            if ("changed".equals(type)) {
                Map<String, Object> value2 = (Map<String, Object>) item.get("value2");
                combinedMap.putAll(value2);
            } else {
                Map<String, Object> value1 = (Map<String, Object>) item.get("value1");
                combinedMap.putAll(value1);
            }
        }

        // Сериализуем результат в JSON
        return "[" + mapperJson.writeValueAsString(combinedMap) + "]";
    }
}
