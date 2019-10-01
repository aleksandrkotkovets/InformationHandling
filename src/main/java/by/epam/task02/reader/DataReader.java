package by.epam.task02.reader;

import by.epam.task02.exception.ReadDataException;
import by.epam.task02.validator.FileValidator;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = Logger.getLogger(DataReader.class);


    public String readData(String path) throws ReadDataException {
        File file = new File(path);
        FileValidator fileValidator = new FileValidator();
        if(!fileValidator.checkFile(file)) {
            LOGGER.warn("File:" + path + "  is not exist or empty");
            throw new ReadDataException("File is not exist or empty - " + path);
        }
        try {
            List<String> allLines = Files.readAllLines(file.toPath());
            LOGGER.info("File:" + file + " was successfully read");
            String allText = String.join(" ", allLines);
            return allText;
        } catch (IOException e) {
            LOGGER.warn("File:" + path + ". Exception with readAllLines method");
            LOGGER.fatal(e);
            throw new ReadDataException(e);
        }
    }
}
