package elements;

public class H1 extends Element{

    public H1(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return "\n" + "        " + "<h1>" + text + "</h1>";
    }
}
