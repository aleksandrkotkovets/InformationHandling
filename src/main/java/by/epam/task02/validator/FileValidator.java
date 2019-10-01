package by.epam.task02.validator;

import java.io.File;

public class FileValidator {


    public boolean checkFile(File file) {
        return !(file == null || !file.exists() || file.isDirectory() || file.length() == 0);
    }


}
