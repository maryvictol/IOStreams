package test.java;

import main.java.TextStream;
import main.java.Utils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStreamTest {
    @Test
    public void readNonExistingFile() {
        try {
            StringBuffer resultTextString = TextStream.readTextStream("src/1111000.txt");
            assertEquals(0, resultTextString.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkReadBinaryStreamFromExistingFile(){
        try {
            StringBuffer resultString = TextStream.readTextStream("src/testFile1.txt");
            String expectedString = "public void readFile(String fileName) {BufferedInputStream inputFile;" +
                    " Pattern pattern = Pattern.compile(keyWords); try";
            assertTrue(expectedString.equals(resultString.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkKeyWordsNumberInStream() {
        try {
            StringBuffer resultTextString = TextStream.readTextStream("src/1111.txt");
            String expectedResult = " catch  (char)  int   new  (new   new  public   try   void   while  \n" +
                    " Найдено ключевых слов: 10";
            assertEquals("Result string doesn't equal expected:", expectedResult,
                    Utils.analyzeString(resultTextString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkKeyWordsInEmptyFile() {
        StringBuffer resultTextString = null;
        String expectedResult = "\n Найдено ключевых слов: 0";
        try {
            resultTextString = TextStream.readTextStream("src/empty.txt");
            assertEquals("Result string doesn't equal expected:", expectedResult,
                    Utils.analyzeString (resultTextString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkWordsConsistingOfSeveralKeyWords() {
        StringBuffer resultString = new StringBuffer();
        resultString.append("publicintprivate");
        String expectedResult = "\n Найдено ключевых слов: 0";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                Utils.analyzeString (resultString));
    }

    @Test
    public void checkWordsConsistsOfNumberAndKeyWord() {
        StringBuffer resultString = new StringBuffer();
        resultString.append("12public");
        String expectedResult = "\n Найдено ключевых слов: 0";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                Utils.analyzeString (resultString));
    }

    @Test
    public void checkWordsConsistsOfKeyWordAndNumber() {
        StringBuffer resultString = new StringBuffer();
        resultString.append("12public");
        String expectedResult = "\n Найдено ключевых слов: 0";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                Utils.analyzeString (resultString));
    }

    @Test
    public void checkWriteBinaryStreamMethod() {
        String inputString = "public void readFile(String fileName) {BufferedInputStream inputFile;" +
                " Pattern pattern = Pattern.compile(keyWords); try";
        try {
            TextStream.writeTextStream(inputString,"testFile2.txt");
            StringBuffer resultString = TextStream.readTextStream("testFile2.txt");
            assertTrue(inputString.equals(resultString.toString()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
