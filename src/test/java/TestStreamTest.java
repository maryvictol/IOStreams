package test.java;

import main.java.TextStream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStreamTest {
    @Test
    public void readNonExistingFile() {
        TextStream textStream = new TextStream();
        StringBuilder resultTextString = textStream.readTextStream("src/1111000.txt");
        assert(true);
    }

    @Test
    public void checkKeyWordsNumberInStream() {
        TextStream textStream = new TextStream();
        StringBuilder resultTextString = textStream.readTextStream("src/1111.txt");
        String expectedResult = "public void try new new int byte new while byte char byte catch int \n" +
                " Найдено ключевых слов: 14";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                textStream.analyzeString(resultTextString));
    }

    @Test
    public void checkKeyWordsInEmptyFile() {
        TextStream textStream = new TextStream();
        StringBuilder resultString = textStream.readTextStream("src/empty.txt");
        String expectedResult = "\n Найдено ключевых слов: 0";
        assertEquals("Result string doesn't equal expected:", expectedResult,
                textStream.analyzeString (resultString));
    }

    @Test
    public void writeFileWithEmptyName() {
        TextStream textStream = new TextStream();
        String resultString = "\n Найдено ключевых слов: 0";
        textStream.writeTextStream(resultString,"");
        assert(true);
    }

}
