package designPattern.chainofresponsbility;

public class ErrorLogger implements Logger  {

    @Override
    public void setNextLogger(Logger nextLogger) {
        // ErrorLogger is the end of the chain; no next logger needed.
    }
    @Override
    public void logMessage(int level, String message) {
        if (level == 3) {
            System.out.println("ERROR: " + message);
        }
    }
}
