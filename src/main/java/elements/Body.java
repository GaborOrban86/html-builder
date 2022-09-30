package elements;

public class Body extends MainElement{

    @Override
    public String toString() {
        return "    " + "<body>" +
                listToString() +
                 "\n" + "    " + "</body>";
    }

    public String listToString() {
        String result = "";
        for (Element element : elements) {
            result = result + element.toString();
        }
        return result;
    }
}
