package by.epam.task02.logic;

import by.epam.task02.entity.Composite;
import by.epam.task02.parser.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortLexemesTest {

    public final static String TEXT = "my team is not ttired.";

    public final static String RIGHT_TEXT = "is my not team ttired.";

    @Test
    public void testSortLexemesBySomeCharacter() {
        SortLexemes sortLexemes = new SortLexemes();
        TextParser dataParser = new TextParser();

        Composite text = dataParser.handleParserRequest(TEXT);
        Composite actual = sortLexemes.sortLexemesBySomeCharacter(text, 't');
        Assert.assertEquals(actual.reconstructComponent(), RIGHT_TEXT);
    }

}
