package by.epam.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Symbol implements Component {

    private static ComponentType componentType = ComponentType.SYMBOL;
    private char symbol;

    private List<Component> componentList = new ArrayList<>();

    public Symbol(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public String reconstructComponent() {
        return String.valueOf(symbol);
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }

    @Override
    public List<Component> getAllChildren() {
        return componentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol &&
                Objects.equals(componentList, symbol1.componentList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(symbol, componentList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Symbol{");
        sb.append("symbol=").append(symbol);
        sb.append(", componentList=").append(componentList);
        sb.append('}');
        return sb.toString();
    }
}
