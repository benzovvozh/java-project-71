package hexlet.code;

import java.util.TreeSet;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.ArrayList;

public class MapComparator {
    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {
        // сортируем уникальные ключи
        var keys = new TreeSet<>();

        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        Map<String, Object> matches = new TreeMap<>((key1, key2) -> {
            if (key1.startsWith("+ ") && key2.startsWith("- ")) {
                return 1;
            }
            return key1.substring(2).compareTo(key2.substring(2));
        });

        List<Map<String, Object>> result = new ArrayList<>();

        for (var key : keys) {

            if (file1.containsKey(key) && file2.containsKey(key)) {           //если есть и в 1 и в 2
                if (file1.get(key).equals(file2.get(key))) {                  //если равны
                    matches.put((String) "  " + key, file1.get(key));
                } else if (!file1.get(key).equals(file2.get(key))) {          //если не равны
                    matches.put((String) "- " + key, file1.get(key));         //добавляем оба значения
                    matches.put((String) "+ " + key, file2.get(key));
                }
            } else if (file1.containsKey(key) && (!file2.containsKey(key))) { //если есть в 1, но нет в 2
                matches.put((String) "- " + key, file1.get(key));
            } else {                                                          // если нет в 1, но есть во 2
                matches.put((String) "+ " + key, file2.get(key));
            }
        }
        result.add(matches);
        return result;
    }
}
