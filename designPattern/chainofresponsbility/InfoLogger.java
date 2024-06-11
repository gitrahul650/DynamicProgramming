package designPattern.chainofresponsbility;

public class InfoLogger implements Logger {
    private Logger nextLogger;
    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }
    @Override
    public void logMessage(int level, String message) {
        if (level == 1) {
            System.out.println("INFO: " + message);
        }
    }
}
