import elements.*;

public class EveryThingToRun {
    private Html finalHtml = new Html();
    private Head head = new Head();
    private Title title = new Title("Teszt Feladat");
    private Body body = new Body();
    private H1 h1 = new H1("Teszt Feladat");
    private P p1 = new P();
    private A a1 = new A();
    private P p2 = new P("A feladat elkészítőjének adatai");
    private Table table = new Table();
    private Tr tr1 = new Tr();
    private Td td1 = new Td();
    private Td td2 = new Td();
    private Tr tr2 = new Tr();
    private Td td3 = new Td();
    private Td td4 = new Td();
    private A a2 = new A();

    public Html setEverything(String repositoryUrl, String[] arr) {
        td1.setText("Név");
        td2.setText(arr[0]);
        td3.setText("Elérhetőség");
        td4.setText(arr[1]);
        tr1.getElements().add(td1);
        tr1.getElements().add(td2);
        tr2.getElements().add(td3);
        tr2.getElements().add(td4);
        table.setBorderSize("1px solid black");
        table.getTrElements().add(tr1);
        table.getTrElements().add(tr2);
        a1.setTextForA(repositoryUrl);
        a1.setText("Megoldás");
        a2.setTextForA("http://lpsolutions.hu");
        a2.setText("L&P Solutions");
        p1.setText(a1.toString().substring(a1.toString().indexOf("<a")));
        body.getElements().add(h1);
        body.getElements().add(p1);
        body.getElements().add(p2);
        body.getElements().add(table);
        body.getElements().add(a2);
        head.getElements().add(title);

        finalHtml.getElements().add(head);
        finalHtml.getElements().add(body);
        return finalHtml;
    }

    public Html getFinalHtml() {
        return finalHtml;
    }

    public EveryThingToRun setFinalHtml(Html finalHtml) {
        this.finalHtml = finalHtml;
        return this;
    }

    public Head getHead() {
        return head;
    }

    public EveryThingToRun setHead(Head head) {
        this.head = head;
        return this;
    }

    public Title getTitle() {
        return title;
    }

    public EveryThingToRun setTitle(Title title) {
        this.title = title;
        return this;
    }

    public Body getBody() {
        return body;
    }

    public EveryThingToRun setBody(Body body) {
        this.body = body;
        return this;
    }

    public H1 getH1() {
        return h1;
    }

    public EveryThingToRun setH1(H1 h1) {
        this.h1 = h1;
        return this;
    }

    public P getP1() {
        return p1;
    }

    public EveryThingToRun setP1(P p1) {
        this.p1 = p1;
        return this;
    }

    public A getA1() {
        return a1;
    }

    public EveryThingToRun setA1(A a1) {
        this.a1 = a1;
        return this;
    }

    public P getP2() {
        return p2;
    }

    public EveryThingToRun setP2(P p2) {
        this.p2 = p2;
        return this;
    }

    public Table getTable() {
        return table;
    }

    public EveryThingToRun setTable(Table table) {
        this.table = table;
        return this;
    }

    public Tr getTr1() {
        return tr1;
    }

    public EveryThingToRun setTr1(Tr tr1) {
        this.tr1 = tr1;
        return this;
    }

    public Td getTd1() {
        return td1;
    }

    public EveryThingToRun setTd1(Td td1) {
        this.td1 = td1;
        return this;
    }

    public Td getTd2() {
        return td2;
    }

    public EveryThingToRun setTd2(Td td2) {
        this.td2 = td2;
        return this;
    }

    public Tr getTr2() {
        return tr2;
    }

    public EveryThingToRun setTr2(Tr tr2) {
        this.tr2 = tr2;
        return this;
    }

    public Td getTd3() {
        return td3;
    }

    public EveryThingToRun setTd3(Td td3) {
        this.td3 = td3;
        return this;
    }

    public Td getTd4() {
        return td4;
    }

    public EveryThingToRun setTd4(Td td4) {
        this.td4 = td4;
        return this;
    }

    public A getA2() {
        return a2;
    }

    public EveryThingToRun setA2(A a2) {
        this.a2 = a2;
        return this;
    }
}
