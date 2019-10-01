package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberParserTest {

    private final static String EXPECTED_NUMBER = "51";

    @Test
    public void testHandleParserRequest(){
        NumberParser numberParser = new NumberParser();

        Component actual = numberParser.handleParserRequest(EXPECTED_NUMBER);

        Assert.assertEquals(actual.reconstructComponent(),EXPECTED_NUMBER);
    }
}
