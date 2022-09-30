import elements.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BuilderService {

    private String htmlString;
    private final List<String> elements = List.of("h1", "p", "a", "table", "tr", "td");

// String solution:
//    public void htmlStringMaker(String[] arr) {
//        if (arr.length < 2) {
//            setHtml("A szükséges adatokat meg kell adni!");
//        } else {
//            setHtml("<!DOCTYPE html>\n" +
//                    "<html>\n" +
//                    "    <head>\n" +
//                    "        <title>Teszt Feladat</title>\n" +
//                    "    </head>\n" +
//                    "    <body>\n" +
//                    "        <h1>Teszt Feladat</h1>\n" +
//                    "        <p><a href=\"" + getRepositoryUrl() + "\">Megoldás</a></p>\n" +
//                    "        <p>A feladat elkészítőjének adatai</p>\n" +
//                    "        <table border=\"1px solid black\">\n" +
//                    "            <tr>\n" +
//                    "                <td>Név</td>\n" +
//                    "                <td>" + arr[0] + "</td>\n" +
//                    "            </tr>\n" +
//                    "            <tr>\n" +
//                    "                <td>Elérhetőség</td>\n" +
//                    "                <td>" + arr[1] + "</td>\n" +
//                    "            </tr>\n" +
//                    "        </table>\n" +
//                    "        <a href=\"http://lpsolutions.hu\">L&P Solutions</a>\n" +
//                    "    </body>\n" +
//                    "</html>");
//        }
//    }

//    public void deleteLines(String allText, String toDelete) {
//        String lineStart = "<" + toDelete;
//        String lineEnd = "</" + toDelete + ">";
//        int lineStartIndex;
//        int lineEndIndex;
//
//        while (allText.contains(lineStart)) {
//            lineStartIndex = allText.indexOf(lineStart);
//            lineEndIndex = allText.indexOf(lineEnd);
//            String deleteText = allText.substring(lineStartIndex, lineEndIndex);
//            allText = allText.replace(deleteText, "*del");
//            allText = allText.replaceFirst(lineEnd, "*del");
//        }
//        String[] lines = allText.split("\n");
//
//        for (int i = 0; i < lines.length; i++) {
//            if (lines[i].contains("*del")) {
//                lines[i] = "";
//            }
//        }
//
//        StringBuilder finalStringBuilder = new StringBuilder();
//        for (String s : lines) {
//            if (!s.isEmpty()) {
//                finalStringBuilder.append(s).append(System.getProperty("line.separator"));
//            }
//        }
//        setHtml(finalStringBuilder.toString());
//    }

    public void deleteHtmlElements(Html html, String element) {
        List<Element> listOfElements = html.getElements().get(1).getElements();
        List<Element> listToDelete = new ArrayList<>();
        switch (element) {
            case "h1":
                for (Element elementOfList : listOfElements) {
                    if (elementOfList.getClass().equals(H1.class)) {
                        listToDelete.add(elementOfList);
                    }
                }
                listOfElements.removeAll(listToDelete);
                break;
            case "p":
                for (Element elementOfList : listOfElements) {
                    if (elementOfList.getClass().equals(P.class)) {
                        listToDelete.add(elementOfList);
                    }
                }
                listOfElements.removeAll(listToDelete);
                break;
            case "a":
                for (Element elementOfList : listOfElements) {
                    if (elementOfList.getClass().equals(A.class)) {
                        listToDelete.add(elementOfList);
                    } else if (elementOfList.getClass().equals(P.class) && elementOfList.getText().contains("<a")) {
                        elementOfList.setText("");
                    }
                }
                listOfElements.removeAll(listToDelete);
                break;
            case "table":
                for (Element elementOfList : listOfElements) {
                    if (elementOfList.getClass().equals(Table.class)) {
                        listToDelete.add(elementOfList);
                    }
                }
                listOfElements.removeAll(listToDelete);
                break;
            case "tr":
                for (Element elementOfList : listOfElements) {
                    if (elementOfList.getClass().equals(Table.class)) {
                        ((Table) elementOfList).getTrElements().clear();
                    }
                }
                break;
            case "td":
                for (Element elementOfList : listOfElements) {
                    if (elementOfList.getClass().equals(Table.class)) {
                        List<Tr> trList = ((Table) elementOfList).getTrElements();
                        for (Tr tr : trList) {
                            tr.getElements().clear();
                        }
                    }
                }
                break;

            default:
                System.out.println("Rossz bemenet!");
        }
        htmlString = html.toString();
    }

    public void htmlFileMaker(String string) {
        System.out.println(string);
        Path path = Path.of("src/main/java/output.html");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write(string);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHtmlString() {
        return htmlString;
    }

    public BuilderService setHtmlString(String htmlString) {
        this.htmlString = htmlString;
        return this;
    }

    public List<String> getElements() {
        return elements;
    }
}
