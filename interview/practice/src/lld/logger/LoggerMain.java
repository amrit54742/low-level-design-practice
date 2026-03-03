package lld.logger;

import lld.logger.model.ConsoleLogger;
import lld.logger.model.FileLogger;
import lld.logger.model.LogLevel;
import lld.logger.service.Logger;

public class LoggerMain {
    public static void main(String[] args) {
        Logger logger= Logger.getInstance();
        logger.addAppender(new ConsoleLogger());
        logger.addAppender(new FileLogger("app.log"));
        logger.setLogLevel(LogLevel.INFO);
        logger.log(LogLevel.DEBUG, "Debug message"); // ignored
        logger.log(LogLevel.INFO, "Application started");
        logger.log(LogLevel.ERROR, "Something went wrong");

    }
}
