package test.java;
import main.java.Utils;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import main.java.BinaryStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class BinaryStreamTest {

    @Test
    public void readNonExistingFile(){
        try {
            StringBuffer resultString = BinaryStream.readBinaryStream("src/111100000.txt");
            assertEquals(0, resultString.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkReadBinaryStreamFromExistingFile(){
        try {
            StringBuffer resultString = BinaryStream.readBinaryStream("src/testFile1.txt");
            String expectedString = "public void readFile(String fileName) {BufferedInputStream inputFile;" +
                    " Pattern pattern = Pattern.compile(keyWords); try";
            assertTrue(expectedString.equals(resultString.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkKeyWordsNumberInStream() {
        StringBuffer resultString = null;
        try {
            resultString = BinaryStream.readBinaryStream("src/1111.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String expectedResult = " catch  (char)  int   new  (new   new  public   try   void   while  \n" +
                " Найдено ключевых слов: 10";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                Utils.analyzeString (resultString));
    }

    @Test
    public void checkKeyWordsInEmptyFile() {
        StringBuffer resultString = null;
        String expectedResult = "\n Найдено ключевых слов: 0";
        try {
            resultString = BinaryStream.readBinaryStream("src/empty.txt");
            assertEquals("Result string doesn't equal expected:", expectedResult,
                    Utils.analyzeString (resultString));
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
            BinaryStream.writeBinaryStream(inputString,"testFile2.txt");
            StringBuffer resultString = BinaryStream.readBinaryStream("testFile2.txt");
            assertTrue(inputString.equals(resultString.toString()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
