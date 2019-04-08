package main.java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryStream {

    public String keyWords = "abstract|boolean|break|byte|byvalue|case|cast|catch|char|class|const|continue|default|do|double|" +
            "else|extends|false|final|finally|float|for|future|generic|goto|if|implements|import|inner|instanceof|" +
            "int|interface|long|native|new|null|operator|outer|package|private|protected|public|rest|return|short|" +
            "static|super|switch|syncronized|this|throw|throws|transient|true|try|var|void|volatile|while";


    public StringBuffer readBinaryStream(String fileName) {
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

    public String analyzeString(StringBuffer resultString) {
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

    public void writeBinaryStream(String resultString, String keyWordsFileName) {
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