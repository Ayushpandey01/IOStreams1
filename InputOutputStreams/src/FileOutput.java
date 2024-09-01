import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(FileOutput.class);

    public static void main(String[] args) {
        FileOutputStream output = null;
        try {
            String text = "Output Stream Content: This text will be read into the byte array and then the file output stream object will write this text into the destination file";
            output = new FileOutputStream("container/destination_file.txt");
            byte[] byteArray = text.getBytes();
            output.write(byteArray);
            logger.info("Successfully wrote to the file.");
        } catch (IOException e) {
            logger.error("An error occurred while writing to the file: {}", e.getMessage());
        } finally {
            // Ensure that the output stream is closed even if an exception occurs
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                logger.error("Failed to close the file output stream: {}", e.getMessage());
            }
        }
    }
}
