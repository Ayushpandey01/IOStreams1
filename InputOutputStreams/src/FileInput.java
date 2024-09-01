import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(FileInput.class);

    public static void main(String[] args) {
        FileInputStream input = null;
        try {
            // Initialize FileInputStream
            input = new FileInputStream("container/sourcefile.txt");
            int i;
            while ((i = input.read()) != -1) {
                System.out.print((char) i);
            }
            logger.info("File read successfully.");
        } catch (IOException e) {
            logger.error("An error occurred while reading the file: {}", e.getMessage());
        } finally {
            // Close the input stream in the finally block to ensure it's closed even if an exception occurs
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                logger.error("Failed to close the file input stream: {}", e.getMessage());
            }
        }
    }
}
