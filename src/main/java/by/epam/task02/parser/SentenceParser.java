package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.ComponentType;
import by.epam.task02.entity.Composite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class SentenceParser implements  DataParser{
    private final static Logger LOGGER = LogManager.getLogger(SentenceParser.class);

    private final static String SPLIT_REGEX = "\\s";

    private LexemeParser nextParser;

    public SentenceParser() {
        this.nextParser = new LexemeParser();
        LOGGER.info("Next parser - LexemeParser.");
    }

    @Override
    public boolean hasNextParser() {
        return nextParser != null;
    }

    @Override
    public Composite handleParserRequest(String string) {
        List<String> lexemesInStrings = Arrays.asList(string.split(SPLIT_REGEX));
        Composite sentenceComposite = new Composite(ComponentType.SENTENCE);

        for (String lexeme: lexemesInStrings) {
            Component lexemeComposite = nextParser.handleParserRequest(lexeme);
            sentenceComposite.add(lexemeComposite);
        }
        LOGGER.info("Add lexemes in sentence.");
        return sentenceComposite;
    }
}
