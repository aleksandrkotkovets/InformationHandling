package by.epam.task02.logic;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.Composite;

import java.util.Comparator;
import java.util.List;

public class SortParagraphs {

    public Composite sortParagraphsByAmountOfSentences(Composite realText){
        Composite text = new Composite(realText);
        List<Component> paragraphs = text.getAllChildren();
        paragraphs.sort(Comparator.comparing(par -> par.getAllChildren().size()));
        return text;
    }
}
