package hexlet.code;

import hexlet.code.utils.Data;
import hexlet.code.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Objects;


public class MapComparator {


    public static List<Data> compare(Map<String, Object> file1, Map<String, Object> file2) {
        // копируем две мапы в одну
        Map<String, Object> keys = new HashMap<>(file1);
        keys.putAll(file2);

        // создаём список мап
        List<Data> result = new ArrayList<>();

        // создаем TreeMap для сортировки мап по алфавиту
        var sortedMap = new TreeMap<>(keys);

        // обход ключей
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
                    result.add(new Data(key.toString(), Status.UNCHANGED, value1, value2));

                    // если не равны
                } else if (!Objects.equals(value1, value2)) {
                    result.add(new Data(key.toString(), Status.CHANGED, value1, value2));
                }

                //если есть в 1, но нет в 2
            } else if (file1.containsKey(key) && (!file2.containsKey(key))) {
                result.add(new Data(key.toString(), Status.REMOVED, value1));

                // если нет в 1, но есть во 2
            } else {
                result.add(new Data(key.toString(), Status.ADDED, value1, value2));
            }
        }
        // получаем список Data, в котором записаны ключи, статус, значение
        return result;
    }
}
