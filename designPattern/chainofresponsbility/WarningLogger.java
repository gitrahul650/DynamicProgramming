package designPattern.chainofresponsbility;

public class WarningLogger implements Logger {
    private Logger nextLogger;
    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
    @Override
    public void logMessage(int level, String message) {
        if (level == 2) {
            System.out.println("WARNING: " + message);
        }
    }
}

