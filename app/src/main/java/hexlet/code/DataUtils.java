package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataUtils {
    public static final String STATUS = "STATUS";
    public static final String FIELD = "FIELD";
    public static final String SAME = "SAME";
    public static final String CHANGED = "CHANGED";
    public static final String ADDED = "ADDED";
    public static final String DELETED = "DELETED";
    public static final String OLD_VALUE = "OLD_VALUE";
    public static final String NEW_VALUE = "NEW_VALUE";
    private static Path getFixedPath(String fileName) {
        return Path.of(new File(fileName).getAbsolutePath());
    }

    public static String readFixedPath(String fileName) throws Exception {

        Path filePath = getFixedPath(fileName);
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
