// Logger.java - Singleton Implementation
class Logger {
    private static Logger instance = new Logger(); // Eager initialization

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

// Test class
public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Starting the application.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Performing operations.");

        System.out.println(logger1 == logger2 ? "Only one Logger instance exists." : "Multiple instances exist!");
    }
}
