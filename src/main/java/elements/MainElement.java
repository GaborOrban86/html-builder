package elements;

import java.util.ArrayList;
import java.util.List;

public abstract class MainElement {
    protected List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return elements;
    }

    public MainElement setElements(List<Element> elements) {
        this.elements = elements;
        return this;
    }
}
