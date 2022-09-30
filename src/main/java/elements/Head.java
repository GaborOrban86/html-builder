package elements;

public class Head extends MainElement{

    @Override
    public String toString() {
        return "    " + "<head>\n" +
                "        " + listToString() + "\n" +
                "    " + "</head>" + "\n";
    }

    public String listToString() {
        String result = "";
        for (Element element : elements) {
            result = result + element.toString();
        }
        return result;
    }

}
