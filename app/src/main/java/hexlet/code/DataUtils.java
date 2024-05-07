package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataUtils {
    private static Path getFixedPath(String fileName) {
        //формируется абсолютный путь к файлу
        return Paths.get("src", "test", "resources", fileName).toAbsolutePath().normalize();
    }

    public static String readFixedPath(String fileName) throws Exception {
        Path filePath = getFixedPath(fileName);
        // Проверяем существование файла
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        return Files.readString(filePath);
    }
}
