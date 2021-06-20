package helpers;

public class Logger {
    private Logger() {}
    private static final String LOGGER_TAG = "[DEBUG] ";
    public static void log(Object string) {
        System.out.println(LOGGER_TAG+string);
    }
}
