package elements;

public class Title extends Element{

    public Title(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return "<title>" + text + "</title>";
    }
}
