package singleton.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String currentFileName;
    // Logs folder relative to the working directory (DesignPatternsAssignments)
    private static final String LOG_DIRECTORY = "Assignment5/src/main/java/singleton/logger/logs";

    private Logger() {
        // Create logs directory if it doesn't exist
        createLogDirectory();
        // Initialize with default file name
        this.currentFileName = "default_log.txt";
        openFile(currentFileName);
    }

    private void createLogDirectory() {
        File directory = new File(LOG_DIRECTORY);
        if (!directory.exists()) {
            try {
                directory.mkdirs();
                System.out.println("Log directory created: " + directory.getAbsolutePath());
            } catch (SecurityException e) {
                System.err.println("Error creating log directory: " + e.getMessage());
            }
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        try {
            // Close current file
            if (writer != null) {
                writer.close();
            }
            // Open new file
            this.currentFileName = fileName;
            openFile(fileName);
            System.out.println("Log file changed to: " + LOG_DIRECTORY + File.separator + fileName);
        } catch (IOException e) {
            System.err.println("Error closing current file: " + e.getMessage());
        }
    }

    private void openFile(String fileName) {
        try {
            String filePath = LOG_DIRECTORY + File.separator + fileName;
            writer = new BufferedWriter(new FileWriter(filePath, true));
            System.out.println("Logger initialized with file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
        }
    }

    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush(); // Ensure the message is written immediately
            } else {
                System.err.println("Logger is not initialized properly.");
            }
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                System.out.println("Logger closed.");
            }
        } catch (IOException e) {
            System.err.println("Error closing log file: " + e.getMessage());
        }
    }
}
