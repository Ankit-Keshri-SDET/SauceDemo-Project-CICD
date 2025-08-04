package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoggerUtils {
    private static final String BASE_LOG_DIR = "logs";

    public static void initLogs() {
        String dateFolder = LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
        String logDirPath = BASE_LOG_DIR + "/" + dateFolder;

        Path logPath = Paths.get(logDirPath);
        if (!Files.exists(logPath)) {
            try {
                Files.createDirectories(logPath);
                System.out.println("Created log directory: " + logDirPath);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create log directory: " + logDirPath, e);
            }
        }
        System.setProperty("logFolder", logDirPath);
    }
}
