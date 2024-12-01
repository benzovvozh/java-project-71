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

            Map<String, Object> value1 = new HashMap<>();
            Map<String, Object> value2 = new HashMap<>();
            value1.put(key, file1.get(key));
            value2.put(key, file2.get(key));


            Map<String, Object> node = new HashMap<>();
            if (value1.get(key) == null) {
                value1.put(key, "null");
            }
            if (value2.get(key) == null) {
                value2.put(key, "null");
            }


            // сравнение ключей
            // если есть и в 1 и в 2
            if (file1.containsKey(key) && file2.containsKey(key)) {

                // если равны
                if (Objects.equals(value1, value2)) {
                    node.put("type", "unchanged");
                    node.put("value1", value1);
                    result.add(node);
                    // если не равны
                } else {
                    node.put("type", "changed");
                    node.put("value1", value1);
                    node.put("value2", value2);
                    result.add(node);

                }
                //если есть в 1, но нет в 2
            } else if (file1.containsKey(key) && (!file2.containsKey(key))) {
                node.put("type", "deleted");
                node.put("value1", value1);
                result.add(node);

                // если нет в 1, но есть во 2
            } else {
                node.put("type", "added");
                node.put("value1", value2);
                result.add(node);

            }
        }

        return result;
    }


}
