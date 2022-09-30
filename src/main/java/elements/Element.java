package elements;

public abstract class Element {

    public Element() {
    }

    public Element(String text) {
        this.text = text;
    }

    protected String text;

    public String getText() {
        return text;
    }

    public Element setText(String text) {
        this.text = text;
        return this;
    }

}
