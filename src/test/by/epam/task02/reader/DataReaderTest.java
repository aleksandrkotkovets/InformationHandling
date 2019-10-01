package by.epam.task02.reader;

import by.epam.task02.exception.ReadDataException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataReaderTest {

    private DataReader reader;


    @BeforeTest
    public void init(){
        reader = new DataReader();
    }

    @Test(description = "Read data from file")
    public void testReadDataTxtSuccessfully() throws ReadDataException {

        String expected = "    It has survived - not only (five) centuries, but also the leap into, the electronic " +
                "Ipsum passages. And more recently with desktop publishing software like Aldus " +
                "PageMaker including versions of Lorem Ipsum. " +
                "    It is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a " +
                "page when looking at its layout.";

        String actual = reader.readData("data\\testText.txt");
        Assert.assertEquals(actual, expected);
    }


    @Test(description = "file is not exist or empty", expectedExceptions = ReadDataException.class)
    public void testFileExistence() throws ReadDataException {
        String actual = reader.readData("data\\another.txt");
    }

}
