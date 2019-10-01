package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordParserTest {

    private final static String EXPECTED_WORD = "  developer  ";

    @Test
    public void testHandleParserRequest() {
        WordParser wordParser = new WordParser();
        Component actual = wordParser.handleParserRequest(EXPECTED_WORD);
        Assert.assertEquals(actual.reconstructComponent(), EXPECTED_WORD);
    }


}
