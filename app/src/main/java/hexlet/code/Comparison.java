package hexlet.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.ArrayList;


public class Comparison {
    public static List<Map<String, Object>> compare(Map<String, Object> fileData1, Map<String, Object> fileData2) {
        var keys = new TreeSet<String>();
        keys.addAll(fileData1.keySet());
        keys.addAll(fileData2.keySet());
        List<Map<String, Object>> comparingResult = new ArrayList<>();

        for (String key : keys) {
            comparingResult.add(compareFields(key, fileData1, fileData2));
        }
        return comparingResult;
    }

    private static Map<String, Object> compareFields(String key, Map<String, Object> fileData1,
                                                      Map<String, Object> fileData2) {
        Map<String, Object> map = new HashMap<>();
        map.put("FIELD", key);

        Object oldValue = (fileData1.get(key) == null) ? String.valueOf(fileData1.get(key)) : fileData1.get(key);
        Object newValue = (fileData2.get(key) == null) ? String.valueOf(fileData2.get(key)) : fileData2.get(key);

        if (fileData1.containsKey(key) && fileData2.containsKey(key)) {

            if (oldValue.equals(newValue)) {
                map.put("STATUS", "SAME");
                map.put("OLD_VALUE", oldValue);
            } else {
                map.put("STATUS", "CHANGED");
                map.put("OLD_VALUE", oldValue);
                map.put("NEW_VALUE", newValue);
            }

        } else if (fileData1.containsKey(key)) {
            map.put("STATUS", "DELETED");
            map.put("OLD_VALUE", oldValue);
        } else if (fileData2.containsKey(key)) {
            map.put("STATUS", "ADDED");
            map.put("NEW_VALUE", newValue);
        }
        return map;
    }
}
