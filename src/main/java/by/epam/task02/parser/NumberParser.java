package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.ComponentType;
import by.epam.task02.entity.Composite;

public class NumberParser implements DataParser{

    private SymbolParser nextParser;


    public NumberParser(){
        nextParser = new SymbolParser();
    }

    @Override
    public boolean hasNextParser() {

        return nextParser != null;
    }

    @Override
    public Composite handleParserRequest(String number) {
        Composite numberComposite = new Composite(ComponentType.NUMBER);

        char[] digits = number.toCharArray();
        for (char digit: digits) {
            Component numberComponent = nextParser.handleParserRequest(String.valueOf(digit));
            numberComposite.add(numberComponent);
        }

        return numberComposite;
    }
}
