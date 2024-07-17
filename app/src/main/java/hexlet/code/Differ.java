package hexlet.code;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(String file1, String file2) throws Exception {
        String content1 = DataUtils.readFixedPath(file1);
        String content2 = DataUtils.readFixedPath(file2);

        TreeMap<String, Object> dataContent1 = null;
        TreeMap<String, Object> dataContent2 = null;


        //будто бы надо вставить код, проверяющий формат файла и отдающий это в нужный метод
        if (file1.contains("json")) {
            // Parser.getData() превращает строку в Map (key - value)
            dataContent1 = new TreeMap<>(Parser.getData(content1));
            dataContent2 = new TreeMap<>(Parser.getData(content2));
        } else if (file1.contains("yml")) {
            dataContent1 = new TreeMap<>(Parser.getDataYaml(content1));
            dataContent2 = new TreeMap<>(Parser.getDataYaml(content2));
        }



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
