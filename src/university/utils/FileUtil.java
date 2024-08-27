package university.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class FileUtil {

    private static final Logger logger = Logger.getLogger(FileUtil.class.getName());

    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            logger.info("File read successfully.");
        } catch (IOException e) {
            logger.severe("Error reading file: " + e.getMessage());
        }
    }
}