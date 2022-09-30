package elements;

import java.util.ArrayList;
import java.util.List;


public class Html {

    protected List<MainElement> elements = new ArrayList<>();

    public List<MainElement> getElements() {
        return elements;
    }

    public Html setElements(List<MainElement> elements) {
        this.elements = elements;
        return this;
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                listToString() + "\n" +
                "</html>";
    }

    public String listToString() {
        String result = "";
        for (MainElement element : elements) {
            result = result + element.toString();
        }
        return result;
    }
}
