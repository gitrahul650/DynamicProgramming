package designPattern.chainofresponsbility;

public interface Logger {
    void setNextLogger(Logger nextLogger);
    void logMessage(int level, String message);
}
