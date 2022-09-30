package elements;

import java.util.ArrayList;
import java.util.List;

public class Tr extends Element{

    private List<Td> elements = new ArrayList<>();

    public List<Td> getElements() {
        return elements;
    }

    public Tr setElements(List<Td> elements) {
        this.elements = elements;
        return this;
    }

    @Override
    public String toString() {
        return "            " + "<tr>\n" +
                listToString() +
                "            " + "</tr>" + "\n";
    }

    public String listToString() {
        String result = "";
        for (Element element : elements) {
            result = result + element.toString();
        }
        return result;
    }
}
