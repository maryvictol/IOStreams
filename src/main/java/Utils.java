package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static final String KEY_WORDS = "abstract|boolean|break|byte|byvalue|case|cast|catch|char|class|const|continue|default|do|double|" +
            "else|extends|false|final|finally|float|for|future|generic|goto|if|implements|import|inner|instanceof|" +
            "int|interface|long|native|new|null|operator|outer|package|private|protected|public|rest|return|short|" +
            "static|super|switch|syncronized|this|throw|throws|transient|true|try|var|void|volatile|while";

    public static String analyzeString(StringBuffer resultString) {
        String[] arrayKeyWords = Utils.KEY_WORDS.split("\\|");
        String stringFromBuffer= "";
        int count = 0;
        for(int i=0; i<arrayKeyWords.length; i++) {
            String keyWord = "(^|[^a-zA-Z0-9])" + arrayKeyWords[i] + "([^a-zA-Z0-9]|$)";
            Pattern pattern = Pattern.compile(keyWord);
            Matcher m = pattern.matcher(resultString);
            while (m.find()) {
                stringFromBuffer += (m.group() + " ");
                count++;
            }
        }
        return stringFromBuffer + "\n Найдено ключевых слов: " + count;
    }

}
