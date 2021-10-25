package ru.dataart.academy.java;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        int count = 0;
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                Scanner scanFile = new Scanner(zip, "UTF-8");
                while (scanFile.hasNext()) {
                    for (char symbol : scanFile.next().toCharArray()) {
                        if (symbol == character) {
                            count++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return count;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        int countMaxLength = 0;
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                Scanner scanFile = new Scanner(zip, "UTF-8");
                while (scanFile.hasNextLine()) {
                    //String[] words = scanFile.nextLine().split("(?U)\\W+");
                    String[] words = scanFile.nextLine().split(" ");
                    for (String word : words) {
                        if (word.length() > countMaxLength) {
                            countMaxLength = word.length();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return countMaxLength;
    }

}
