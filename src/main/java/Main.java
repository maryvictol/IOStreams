package main.java;

public class Main {

    public static void main(String[] args) {
        BinaryStream byteStream = new BinaryStream();
        StringBuffer resultString = byteStream.readBinaryStream("src/1111.txt");
        String analyzedString = byteStream.analyzeString(resultString);
        System.out.println(analyzedString);
        String keyWordsFileName = "result.txt";
        byteStream.writeBinaryStream(analyzedString,keyWordsFileName);

        TextStream textStream = new TextStream();
        StringBuilder resultTextString = textStream.readTextStream("src/1111.txt");
        analyzedString = textStream.analyzeString(resultTextString);
        System.out.println(analyzedString);
        textStream.writeTextStream(analyzedString,"result1.txt");

    }
}
