package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.ComponentType;
import by.epam.task02.entity.Composite;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LexemeParser implements DataParser {

    private final static Logger LOGGER = LogManager.getLogger(SentenceParser.class);

    private final static String WORD_REGEX = "([^\\d\\W]+\\-?)+";
    private final static String WORD_REGEX_WITH_BRACKETS = "\\([^\\d\\W]+\\)";

    private final static String WORD_REGEX_WITH_FIRST_BRACKET = "\\([^\\d\\W]+";

    private final static String WORD_REGEX_WITH_LAST_SYMBOL = "\\(?\\w+\\)?[\\)\\,]";

    private final static String MATH_REGEX = "[<<||>>\\&\\|||\\^\\(||\\)]";



    private WordParser nextWordParser;
    private SymbolParser nextSymbolParser;


    public LexemeParser() {
        this.nextWordParser = new WordParser();
        this.nextSymbolParser = new SymbolParser();
        LOGGER.info("Next parser - WordParser.");
        LOGGER.info("Next parser - ExpressionParser.");
        LOGGER.info("Next parser - SymbolParser.");
    }

    @Override
    public boolean hasNextParser() {
        return nextWordParser != null || nextSymbolParser != null;
    }

    @Override
    public Component handleParserRequest(String string) {
        Composite lexeme = new Composite(ComponentType.LEXEMA);

        if (string.length() == 1) {
            addSymbolInLexeme(lexeme, string);

        } else if (string.matches(WORD_REGEX_WITH_BRACKETS)) {
            addWordWithBracketsInLexeme(lexeme, string);

        } else if (string.matches(WORD_REGEX_WITH_FIRST_BRACKET)) {
            addWordWithFirstBracketInLexeme(lexeme, string);

        } else if (string.matches(WORD_REGEX_WITH_LAST_SYMBOL)) {
            addWordWithLastSymbolInLexeme(lexeme, string);

        } else if (string.matches(WORD_REGEX)) {
            addWordInLexeme(lexeme, string);

        } else if (string.matches(MATH_REGEX)) {
        addWordInLexeme(lexeme, string);

    } else {
            LOGGER.warn("Unknown expression: " + string + "!!!");
        }
        return lexeme;
    }


    public void addSymbolInLexeme(Composite lexeme, String string) {
        Component symbol = nextSymbolParser.handleParserRequest(string);
        lexeme.add(symbol);
        LOGGER.info("Add symbol in lexeme");
    }


    public void addWordInLexeme(Composite lexeme, String string) {
        Component word = nextWordParser.handleParserRequest(string);
        lexeme.add(word);
        LOGGER.info("Add word in lexeme");
    }


    public void addWordWithBracketsInLexeme(Composite lexeme, String string) {
        Component symbol1 = nextSymbolParser.handleParserRequest(String.valueOf(string.charAt(0)));
        Component word = nextWordParser.handleParserRequest(string.substring(1, string.length() - 1));
        Component symbol2 = nextSymbolParser.handleParserRequest(String.valueOf(string.charAt(string.length() - 1)));
        lexeme.add(symbol1);
        lexeme.add(word);
        lexeme.add(symbol2);
        LOGGER.info("Add symbol, word, symbol in lexeme");
    }


    public void addWordWithFirstBracketInLexeme(Composite lexeme, String string) {
        Component symbol1 = nextSymbolParser.handleParserRequest(String.valueOf(string.charAt(0)));
        Component word = nextWordParser.handleParserRequest(string.substring(1));
        lexeme.add(symbol1);
        lexeme.add(word);
        LOGGER.info("Add symbol and word in lexeme");
    }


    public void addWordWithLastSymbolInLexeme(Composite lexeme, String string) {
        Component word = nextWordParser.handleParserRequest(string.substring(0, string.length() - 1));
        Component symbol2 = nextSymbolParser.handleParserRequest(String.valueOf(string.charAt(string.length() - 1)));
        lexeme.add(word);
        lexeme.add(symbol2);
        LOGGER.info("Add symbol and word in lexeme");
    }

}
