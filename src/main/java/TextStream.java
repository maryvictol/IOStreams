package main.java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextStream {

    private TextStream() {};

    public static StringBuffer readTextStream(String fileName) throws IOException{
        StringBuffer stringFromInputFile = new StringBuffer();
        try (BufferedReader inputFile =
                     new BufferedReader(new FileReader(fileName))) {
            String charsAvailable;
            while ((charsAvailable = inputFile.readLine()) != null) {
                stringFromInputFile.append(charsAvailable);
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

    public static void writeTextStream(String resultString, String keyWordsFileName) throws IOException{
        try (BufferedWriter keyWordsFile =
                     new BufferedWriter(new FileWriter(keyWordsFileName))) {
            keyWordsFile.write(resultString);
        } catch (FileNotFoundException e) {
            System.out.println("File " + keyWordsFileName + " isn't found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(" Output error");
            e.printStackTrace();
        }
    }
}