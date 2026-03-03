package lld.logger.model;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class ConsoleLogger implements LoggerInterface{

    @Override
    public void log(LogLevel logLevel, String content) {
        System.out.println("At " + LocalDateTime.now() + ", Logging the content in console with log-level " + logLevel + " and the content is " + content);

    }
}
