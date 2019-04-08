package main.java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextStream {
    public String keyWords = "abstract|boolean|break|byte|byvalue|case|cast|catch|char|class|const|continue|default|do|double|" +
            "else|extends|false|final|finally|float|for|future|generic|goto|if|implements|import|inner|instanceof|" +
            "int|interface|long|native|new|null|operator|outer|package|private|protected|public|rest|return|short|" +
            "static|super|switch|syncronized|this|throw|throws|transient|true|try|var|void|volatile|while";

    public StringBuilder readTextStream(String fileName) {
        StringBuilder stringFromInputFile = new StringBuilder();
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

    public String analyzeString(StringBuilder resultString) {
        Pattern pattern = Pattern.compile(keyWords);
        String stringFromBuffer= "";
        int count = 0;

        Matcher m = pattern.matcher(resultString);
        while (m.find()) {
            stringFromBuffer += (m.group() + " ");
            count++;
        }

        return stringFromBuffer + "\n Найдено ключевых слов: " + count;
    }

    public void writeTextStream(String resultString, String keyWordsFileName) {
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
