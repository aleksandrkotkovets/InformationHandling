package by.epam.task02.logic;

import by.epam.task02.entity.Component;
import by.epam.task02.entity.Composite;

import java.util.Comparator;
import java.util.List;

public class SortLexemes {

    public Composite sortLexemesBySomeCharacter(Composite realText, char symbol){
        Composite text = new Composite(realText);
        List<Component> paragraphs = text.getAllChildren();

        for (Component paragraph : paragraphs) {
            for (Component sentence : paragraph.getAllChildren()) {
                List<Component> lexemes = sentence.getAllChildren();
                lexemes.sort(createCompositeComparator(symbol));
            }
        }
        return text;
    }


    private Comparator<Component> createCompositeComparator(char symbol){
        Comparator<Component> symbolAmountComparator = (o1, o2) -> {
            String lexeme1 = o1.reconstructComponent();
            String lexeme2 = o2.reconstructComponent();

            long counter1 = lexeme1.chars().filter(s -> s == symbol).count();
            long counter2 = lexeme2.chars().filter(s -> s == symbol).count();

            return Long.compare(counter1, counter2);
        };

        return symbolAmountComparator.thenComparing(Component::reconstructComponent);
    }

}
