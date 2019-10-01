package by.epam.task02.logic;

import by.epam.task02.entity.Composite;
import by.epam.task02.parser.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortParagraphsTest {

    public final static String TEXT = "    It has survived - not only 5 centuries. But also Lorem Ipsum." +
            "    It is a established fact that a reader will be of a " +
            "page when looking at its layout.    ";


    public final static String RIGHT_TEXT =
            "It is a established fact that a reader will be of a " +
                    "page when looking at its layout." +
                    " It has survived - not only 5 centuries. But also Lorem Ipsum.";


    @Test
    public void testSortParagraphsByAmountOfSentences() {
        SortParagraphs sortParagraphs = new SortParagraphs();
        TextParser dataParser = new TextParser();

        Composite text = dataParser.handleParserRequest(TEXT.trim());
        Composite actual = sortParagraphs.sortParagraphsByAmountOfSentences(text);
        Assert.assertEquals(actual.reconstructComponent(), RIGHT_TEXT);
    }
}
