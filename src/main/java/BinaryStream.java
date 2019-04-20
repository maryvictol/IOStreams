package main.java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import main.java.Utils;

public class BinaryStream {



    private BinaryStream() {}

    public static StringBuffer readBinaryStream(String fileName) throws IOException{
        StringBuffer stringFromInputFile = new StringBuffer();
        try (BufferedInputStream inputFile =
                     new BufferedInputStream(new FileInputStream(fileName))) {
            int bytesAvailable;
            while ((bytesAvailable = inputFile.read()) != -1) {
                stringFromInputFile.append((char) bytesAvailable);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " isn't found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(" Input error");
            e.printStackTrace();
        }
        return stringFromInputFile;
    }

    public static void writeBinaryStream(String resultString, String keyWordsFileName) throws IOException{
        try (FileOutputStream keyWordsFile =
                     new FileOutputStream(keyWordsFileName)) {
            keyWordsFile.write(resultString.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("File " + keyWordsFileName + " isn't found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(" Output error");
            e.printStackTrace();
        }
    }
}