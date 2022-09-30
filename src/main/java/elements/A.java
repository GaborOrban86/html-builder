package elements;

public class A extends Element{

    private String TextForA;

    public A() {
    }

    public A(String textForA) {
        TextForA = textForA;
    }

    public String getTextForA() {
        return TextForA;
    }

    public A setTextForA(String textForA) {
        TextForA = textForA;
        return this;
    }

    @Override
    public String toString() {
        return "\n" + "        " + "<a href=\"" + this.TextForA + "\">" + text + "</a>";
    }
}
