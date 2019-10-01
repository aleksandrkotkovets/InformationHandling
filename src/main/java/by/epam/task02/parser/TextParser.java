package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.ComponentType;
import by.epam.task02.entity.Composite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class TextParser implements DataParser{
    private final static Logger LOGGER = LogManager.getLogger(TextParser.class);

    private final static String SPLIT_REGEX = "\\s{4}\\s*";

    private ParagraphParser nextParser;

    public TextParser() {
        this.nextParser = new ParagraphParser();
        LOGGER.info("Next parser - ParagraphParser.");
    }

    @Override
    public boolean hasNextParser(){
        return nextParser != null;
    }

    @Override
    public Composite handleParserRequest(String string) {
        List<String> paragraphsInStrings = Arrays.asList(string.split(SPLIT_REGEX));
        Composite textComposite = new Composite(ComponentType.TEXT);
        for (String paragraph : paragraphsInStrings) {
            Component paragraphComposite = nextParser.handleParserRequest(paragraph.trim());
            textComposite.add(paragraphComposite);
            LOGGER.info("Add paragraph in text.");
        }
        return textComposite;
    }
}
