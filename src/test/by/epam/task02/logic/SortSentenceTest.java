package by.epam.task02.logic;

import by.epam.task02.entity.Composite;
import by.epam.task02.parser.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

public class SortSentenceTest {


    public final static String TEXT = "my team is not ttired.";

    public final static String RIGHT_TEXT = "my team is not ttired.";

    @Test
    public void testSortLexemesBySomeCharacter() {
        SortSentences sortWords = new SortSentences();
        TextParser dataParser = new TextParser();

        Composite text = dataParser.handleParserRequest(TEXT);
        String actual = sortWords.sortSentence(TEXT);
        Assert.assertEquals(actual, RIGHT_TEXT);
    }
}
