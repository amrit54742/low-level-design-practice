package lld.logger.service;

import lld.logger.model.LogLevel;
import lld.logger.model.LoggerInterface;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Logger {

//    private LoggerInterface loggerInterface;

    private List<LoggerInterface> loggerInterfaceArrayList = new ArrayList<>();

    private static Logger instance;
    private LogLevel currentLogLevel;

    public void setLogLevel(LogLevel logLevel) {
        this.currentLogLevel = logLevel;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

//    public Logger(LoggerInterface loggerInterface) {
//        this.loggerInterface = loggerInterface;
//    }

    public void addAppender(LoggerInterface appender) {
        loggerInterfaceArrayList.add(appender);
    }


    public void log(LogLevel logLevel, String content){
//        loggerInterface.log(logLevel, content);
        if (logLevel.ordinal() < currentLogLevel.ordinal()) {
            return;
        }

        for (LoggerInterface appender : loggerInterfaceArrayList) {
            appender.log(logLevel, content);
        }
    }
}
