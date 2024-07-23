package hexlet.code;

import java.util.*;

public class Comparison {
    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {

        // создаем всевозможные включи по ключам файлов
        var keys = new TreeSet<String>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        // дальше for-each по ключам и формируется List<Map<>>
        List<Map<String, Object>> comparingResult = new ArrayList<>();

        // обходим коллекцию ключей и добавляем их в новые мапы и всё в лист
        for(String key : keys) {
            Map<String, Object> map = new HashMap<>();
            map.put("FIELD", key);

            var value1 = file1.get(key);
            var value2 = file2.get(key);

            if(file1.containsKey(key) && file2.containsKey(key)) {

                if (value1.equals(value2)) {
                    map.put("STATUS", "SAME");
                    map.put("OLD_VALUE", value1);
                } else {
                    map.put("STATUS", "CHANGED");
                    map.put("OLD_VALUE", value1);
                    map.put("NEW_VALUE", value2);
                }

            } else if (file1.containsKey(key)) {
                map.put("STATUS", "DELETED");
                map.put("OLD_VALUE", value1);
            } else if (file2.containsKey(key)) {
                map.put("STATUS", "ADDED");
                map.put("NEW_VALUE", value2);

            }
            comparingResult.add(map);
        }
        return comparingResult;
    }
}
