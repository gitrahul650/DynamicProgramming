package designPattern.chainofresponsbility;

public class Main {
    public static void main(String[] args) {
        Logger infoLogger = new InfoLogger();
        Logger warningLogger = new WarningLogger();
        Logger errorLogger = new ErrorLogger();
        infoLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);
        infoLogger.logMessage(1, "This is an informational message.");
        infoLogger.logMessage(2, "This is a warning message.");
        infoLogger.logMessage(3, "This is an error message.");

        warningLogger.logMessage(1, "This is an informational message.");
        warningLogger.logMessage(2, "This is a warning message.");
        warningLogger.logMessage(3, "This is an error message.");

        errorLogger.logMessage(1, "This is an informational message.");
        errorLogger.logMessage(2, "This is a warning message.");
        errorLogger.logMessage(3, "This is an error message.");
    }
}
