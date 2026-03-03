package lld.logger.model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger implements LoggerInterface{

    private String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(LogLevel logLevel, String content) {
        System.out.println("Logging the content in file and the content is " + content);
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(LocalDateTime.now() +
                    " [" + logLevel + "] " + content + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
