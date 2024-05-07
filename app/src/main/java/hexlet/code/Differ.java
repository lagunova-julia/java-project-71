package hexlet.code;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String file1, String file2) throws Exception {
        String content1 = DataUtils.readFixedPath(file1);
        String content2 = DataUtils.readFixedPath(file2);

        // Parser.getData() превращает строку в Map (key - value)
        var dataContent1 = new TreeMap<>(Parser.getData(content1));
        var dataContent2 = new TreeMap<>(Parser.getData(content2));

        Map<Key, Object> resultMap = new TreeMap<>(Comparator.comparing(Key::getKey)
                .thenComparing(Key::getDiff, Comparator.reverseOrder()));

        for (var part : dataContent1.entrySet()) {
            //получаем значение по ключу из каждой мапы
            String keyPart = part.getKey();
            Object value1 = dataContent1.get(keyPart);
            Object value2 = dataContent2.get(keyPart);

            //смотрим, что ключа нет во второй мапе
            if (!dataContent2.containsKey(keyPart)) {
                resultMap.put(new Key("  - ", keyPart), part.getValue());
            //смотрим, что значения первой мапы различаются со второй
            } else if (!value1.equals(value2)) {
                resultMap.put(new Key("  - ", keyPart), part.getValue());
                resultMap.put(new Key("  + ", keyPart), value2);
            //если всё совпадает
            } else {
                resultMap.put(new Key("    ", keyPart), part.getValue());
            }
        }

        for (var part : dataContent2.entrySet()) {
            String keyPart = part.getKey();
            if (!dataContent1.containsKey(keyPart)) {
                resultMap.put(new Key("  + ", keyPart), part.getValue());
            }
        }

        StringBuilder result = new StringBuilder("{\n");
        for (var entry : resultMap.entrySet()) {
            String temp = entry.getKey().getDiff() + entry.getKey().getKey() + ": " + entry.getValue() + "\n";
            result.append(temp);
        }
        result.append("}");

        return result.toString();
    }
}
