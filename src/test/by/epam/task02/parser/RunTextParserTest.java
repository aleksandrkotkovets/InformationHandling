package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.exception.ReadDataException;
import by.epam.task02.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunTextParserTest {

    public final static String RIGHT_TEXT = "It has survived - not only (five) centuries, but also the leap into " +
            "the electronic typesetting, remaining  essentially  unchanged. It was popularised " +
            "in the  with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including " +
            "versions of Lorem Ipsum." +
            " It is a long established fact that a reader will be distracted by the readable content of " +
            "a page when looking at its layout. The point of using  " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using " +
            "(Content here), content here, making it look like readable English." +
            " It is a  established fact that a reader will be of a " +
            "page when looking at its layout." +
            " Bye.";


    @Test
    public void testHandleParserRequest() throws ReadDataException {

        DataReader reader = new DataReader();
        TextParser textParser = new TextParser();

        String textFromFile = reader.readData("data\\dataFile.txt");
        Component actual = textParser.handleParserRequest(textFromFile.trim());

        Assert.assertEquals(actual.reconstructComponent(), RIGHT_TEXT);
    }
}
