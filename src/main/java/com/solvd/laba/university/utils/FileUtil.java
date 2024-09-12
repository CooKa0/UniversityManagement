package com.solvd.laba.university.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileUtil {

    private static final Logger logger = LogManager.getLogger(FileUtil.class);

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            logger.info("File read successfully.");
        } catch (IOException e) {
            logger.error("Error reading file: " + filePath, e);
        }
        return content.toString();
    }

    public static void writeFile(String filePath, String content) {
        try {
            FileUtils.writeStringToFile(new File(filePath), content, "UTF-8");
            logger.info("File written successfully.");
        } catch (IOException e) {
            logger.error("Error writing file: " + filePath, e);
        }
    }
}