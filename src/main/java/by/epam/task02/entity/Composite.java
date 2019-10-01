package by.epam.task02.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Composite implements Component {

    private ComponentType componentType;
    private List<Component> componentList = new ArrayList<>();

    public Composite(ComponentType componentType) {
        this.componentType = componentType;
    }

    public Composite(Composite composite) {

        if (composite != null) {
            this.componentType = composite.getComponentType();
            componentList = new ArrayList<>(composite.getAllChildren());
        } else throw new RuntimeException();
    }

    @Override
    public String reconstructComponent() {
        String result = " ";
        switch (componentType) {
            case WORD:
            case NUMBER:
            case LEXEMA:
                result = componentList.stream()
                        .map(Component::reconstructComponent)
                        .collect(Collectors.joining());
                break;
            case SENTENCE:
                result = componentList.stream()
                        .map(Component::reconstructComponent)
                        .collect(Collectors.joining(" "));
                break;
            case PARAGRAPH:
                result = componentList.stream()
                        .map(Component::reconstructComponent)
                        .collect(Collectors.joining(""));
                break;
            case TEXT:
                result = componentList.stream()
                        .map(Component::reconstructComponent)
                        .collect(Collectors.joining(" "));
                break;
        }
        return result;
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
        Composite composite = (Composite) o;
        return componentType == composite.componentType &&
                Objects.equals(componentList, composite.componentList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(componentType, componentList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Composite{");
        sb.append("componentType=").append(componentType);
        sb.append(", componentList=").append(componentList);
        sb.append('}');
        return sb.toString();
    }

}
