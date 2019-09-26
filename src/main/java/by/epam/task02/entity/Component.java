package by.epam.task02.entity;

import java.util.List;

public interface Component {

    String reconstructComponent(); //


    ComponentType getComponentType();

    void add(Component component);

    void remove(Component component);

    List<Component> getAllChildren();


}
