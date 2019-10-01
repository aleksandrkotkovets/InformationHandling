package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.ComponentType;
import by.epam.task02.entity.Composite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class WordParser implements DataParser{

    private final static Logger LOGGER = LogManager.getLogger(SentenceParser.class);

    private SymbolParser nextParser;


    public WordParser() {
        this.nextParser = new SymbolParser();
        LOGGER.info("Took the next parser - SymbolParser.");
    }

    @Override
    public boolean hasNextParser() {
        return nextParser != null;
    }

    @Override
    public Composite handleParserRequest(String word) {
        Composite nextComposite = new Composite(ComponentType.WORD);

        char[] symbols = word.toCharArray();
        for (char symbol : symbols) {
            Component wordComponent = nextParser.handleParserRequest(String.valueOf(symbol));
            nextComposite.add(wordComponent);
        }
        LOGGER.info("Add symbols in word.");
        return nextComposite;
    }
}
