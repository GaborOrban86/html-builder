package elements;

public class P extends Element{

    public P() {
    }

    public P(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return "\n" + "        " + "<p>" + text + "</p>";
    }
}
