package test.java;
import org.junit.Test;
import main.java.BinaryStream;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class BinaryStreamTest {

    @Test
    public void readNonExistingFile() {
        BinaryStream byteStream = new BinaryStream();
        StringBuffer resultString = byteStream.readBinaryStream("src/1111000.txt");
        assert(true);
    }

    @Test
    public void checkKeyWordsNumberInStream() {
        BinaryStream byteStream = new BinaryStream();
        StringBuffer resultString = byteStream.readBinaryStream("src/1111.txt");
        String expectedResult = "public void try new new int byte new while byte char byte catch int \n" +
                " Найдено ключевых слов: 14";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                byteStream.analyzeString (resultString));
    }

    @Test
    public void checkKeyWordsInEmptyFile() {
        BinaryStream byteStream = new BinaryStream();
        StringBuffer resultString = byteStream.readBinaryStream("src/empty.txt");
        String expectedResult = "\n Найдено ключевых слов: 0";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                byteStream.analyzeString (resultString));
    }

    @Test
    public void writeFileWithEmptyName() {
        BinaryStream byteStream = new BinaryStream();
        String resultString = "\n Найдено ключевых слов: 0";
        byteStream.writeBinaryStream(resultString,"");
        assert(true);
    }

}
