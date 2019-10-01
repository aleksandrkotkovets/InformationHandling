package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SentenceParserTest {

    public final static String SENTENCE = " It was popularised in the "+
            "5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem "+
            "Ipsum passages, and more recently with desktop publishing software like Aldus "+
            "PageMaker including versions of Lorem Ipsum .";

    public final static String RIGHT_SENTENCE = " It was popularised in the "+
            " with the release of Letraset sheets containing Lorem "+
            "Ipsum passages, and more recently with desktop publishing software like Aldus "+
            "PageMaker including versions of Lorem Ipsum .";


    @Test
    public void testHandleParserRequest() {
        SentenceParser sentenceParser = new SentenceParser();
        Component actual = sentenceParser.handleParserRequest(SENTENCE);
        Assert.assertEquals(actual.reconstructComponent(), RIGHT_SENTENCE);
    }
}
