package main.java;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuffer resultString = null;
        try {
            resultString = BinaryStream.readBinaryStream("src/1111.txt");

            String analyzedString = Utils.analyzeString(resultString);
            System.out.println(analyzedString);
            String keyWordsFileName = "result.txt";

            BinaryStream.writeBinaryStream(analyzedString, keyWordsFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            StringBuffer resultTextString = TextStream.readTextStream("src/1111.txt");
            String analyzedString = Utils.analyzeString(resultTextString);
            System.out.println(analyzedString);
            TextStream.writeTextStream(analyzedString, "result1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
