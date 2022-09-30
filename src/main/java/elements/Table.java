package elements;

import java.util.ArrayList;
import java.util.List;

public class Table extends Element{
    private String borderSize;
    private List<Tr> trElements = new ArrayList<>();

    public String getBorderSize() {
        return borderSize;
    }

    public Table setBorderSize(String borderSize) {
        this.borderSize = borderSize;
        return this;
    }

    public List<Tr> getTrElements() {
        return trElements;
    }

    public Table setTrElements(List<Tr> trElements) {
        this.trElements = trElements;
        return this;
    }

    @Override
    public String toString() {
        return "\n" + "        " + "<table border=\"" + borderSize +"\">\n" +
                listToString() +
                "        " + "</table>";
    }

    public String listToString() {
        String result = "";
        for (Tr element : trElements) {
            result = result + element.toString();
        }
        return result;
    }
}
