package by.epam.task02.parser;

import by.epam.task02.entity.Component;

public interface DataParser {

    /**
     * Получает данные в одной строчке и разделяет их. Разделенные данные помещает в component и возвращает этот component.
     * Takes data in one string and split it. Saves separated data in {@link Component} and return it.
     */

        boolean hasNextParser();

        Component handleParserRequest(String string);
    }