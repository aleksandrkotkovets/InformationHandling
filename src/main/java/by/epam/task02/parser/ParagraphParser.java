package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.ComponentType;
import by.epam.task02.entity.Composite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ParagraphParser implements DataParser{

    private final static Logger LOGGER = LogManager.getLogger(ParagraphParser.class);

    private final static String SPLIT_REGEX = "(\\.\\.\\.)|\\.|\\?|\\!\\s*";

    private SentenceParser nextParser;


    public ParagraphParser() {
        this.nextParser = new SentenceParser();
        LOGGER.info("Next parser - SentenceParser.");
    }

    @Override
    public boolean hasNextParser() {
        return nextParser != null;
    }

    @Override
    public Composite handleParserRequest(String string) {
        List<String> sentencesInStrings = Arrays.asList(string.split(SPLIT_REGEX));
        Composite paragraphComposite = new Composite(ComponentType.PARAGRAPH);
        for (String sentence : sentencesInStrings) {
            Component sentenceComposite = nextParser.handleParserRequest(sentence);
            Component dot = nextParser.handleParserRequest(".");
            paragraphComposite.add(sentenceComposite);
            paragraphComposite.add(dot);
            LOGGER.info("Add sentence in paragraph.");
        }
        return paragraphComposite;

    }
}
