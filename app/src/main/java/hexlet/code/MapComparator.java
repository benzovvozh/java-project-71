package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Objects;


public class MapComparator {

    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        // копируем две мапы в одну
        Map<String, Object> keys = new HashMap<>(file1);
        keys.putAll(file2);

        // создаём список мап
        List<Map<String, Object>> result = new ArrayList<>();

        // создаем TreeMap для сортировки мап по алфавиту
        var sortedMap = new TreeMap<>(keys);

        // обход ключей отсортированных по алфавиту
        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            var key = entry.getKey();

            var value1 = file1.get(key);
            var value2 = file2.get(key);

            // проверка на null
            if (value1 == null) {
                value1 = "null";
            }
            if (value2 == null) {
                value2 = "null";
            }

            // сравнение ключей
            // если есть и в 1 и в 2
            if (file1.containsKey(key) && file2.containsKey(key)) {

                // если равны
                if (Objects.equals(value1, value2)) {
                    result.add(createResultMap("unchanged", key, value1));
                    // если не равны
                } else {
                    result.add(createResultMap("change-", key, value1));
                    result.add(createResultMap("change+", key, value2));
                }
                //если есть в 1, но нет в 2
            } else if (file1.containsKey(key) && (!file2.containsKey(key))) {
                result.add(createResultMap("deleted", key, value1));
                // если нет в 1, но есть во 2
            } else {
                result.add(createResultMap("added", key, value2));

            }
        }
        return result;
    }

    // метод создает результирующую мапу
    private static Map<String, Object> createResultMap(String status, String key, Object value) {
        // создаём маленькую мапу, например fruit: apple
        Map<String, Object> miniMap = new HashMap<>();
        miniMap.put(key, value);
        // создаем мапу-результат, в качестве ключа - статус(строка), а в качестве значения маленькая мапа
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(status, miniMap);
        return resultMap;
    }
}
