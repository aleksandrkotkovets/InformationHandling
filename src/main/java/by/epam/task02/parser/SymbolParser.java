package by.epam.task02.parser;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.Symbol;

public class SymbolParser implements DataParser {

    @Override
    public boolean hasNextParser() {
        return false;
    }

    @Override
    public Component handleParserRequest(String string){
        Component symbol = new Symbol(string.charAt(0));
        return symbol;
    }

}
