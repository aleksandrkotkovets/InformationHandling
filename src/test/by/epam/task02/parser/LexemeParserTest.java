package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LexemeParserTest {

    private LexemeParser lexemeParser;


    @BeforeTest
    public void setUp() {
        lexemeParser = new LexemeParser();
    }


    @DataProvider
    public Object[][] initData() {
        return new Object[][]{
                {"I"},
                {"am"},
                {"okey)"},
                {"I)"},
                {"so,"},
                {"(tired)"},
                {"piy-piy-hi"}
        };
    }


    @Test(dataProvider =  "initData")
    public void testHandleParserRequestAllVariants(String lexeme) {

        Component actual = lexemeParser.handleParserRequest(lexeme);

        Assert.assertEquals(actual.reconstructComponent(), lexeme);
    }
}
