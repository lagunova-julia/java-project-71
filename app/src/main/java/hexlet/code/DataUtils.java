package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataUtils {
    private static Path getFixedPath(String fileName) {
        //формируется абсолютный путь к файлу
        return Path.of(new File(fileName).getAbsolutePath());
    }

    public static String readFixedPath(String fileName) throws Exception {

        Path filePath = getFixedPath(fileName);
        // Проверяем существование файла
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        return Files.readString(filePath);

    }

    public static String getFileType(String filepath) {
        String[] parts = filepath.split("\\.");
        return parts[1];
    }
}
