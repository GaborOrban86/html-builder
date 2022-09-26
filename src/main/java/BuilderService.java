import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BuilderService {

    private String html;
    private String repositoryUrl;
    private final List<String> elements = List.of("h1", "p", "a", "table", "tr", "td");

    public void htmlStringMaker(String[] arr) {
        if (arr.length < 2) {
            setHtml("A szükséges adatokat meg kell adni!");
        } else {
            setHtml("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "    <head>\n" +
                    "        <title>Teszt Feladat</title>\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        <h1>Teszt Feladat</h1>\n" +
                    "        <p><a href=\"" + getRepositoryUrl() + "\">Megoldás</a></p>\n" +
                    "        <p>A feladat elkészítőjének adatai</p>\n" +
                    "        <table border=\"1px solid black\">\n" +
                    "            <tr>\n" +
                    "                <td>Név</td>\n" +
                    "                <td>" + arr[0] + "</td>\n" +
                    "            </tr>\n" +
                    "            <tr>\n" +
                    "                <td>Elérhetőség</td>\n" +
                    "                <td>" + arr[1] + "</td>\n" +
                    "            </tr>\n" +
                    "        </table>\n" +
                    "        <a href=\"http://lpsolutions.hu\">L&P Solutions</a>\n" +
                    "    </body>\n" +
                    "</html>");
        }
    }

    public void deleteLines(String allText, String toDelete) {
        String lineStart = "<" + toDelete;
        String lineEnd = "</" + toDelete + ">";
        int lineStartIndex;
        int lineEndIndex;

        while (allText.contains(lineStart)) {
            lineStartIndex = allText.indexOf(lineStart);
            lineEndIndex = allText.indexOf(lineEnd);
            String deleteText = allText.substring(lineStartIndex, lineEndIndex);
            allText = allText.replace(deleteText, "*del");
            allText = allText.replaceFirst(lineEnd, "*del");
        }
        String[] lines = allText.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("*del")) {
                lines[i] = "";
            }
        }

        StringBuilder finalStringBuilder = new StringBuilder();
        for (String s : lines) {
            if (!s.isEmpty()) {
                finalStringBuilder.append(s).append(System.getProperty("line.separator"));
            }
        }
        setHtml(finalStringBuilder.toString());
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

    public String getHtml() {
        return html;
    }

    public BuilderService setHtml(String html) {
        this.html = html;
        return this;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public BuilderService setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
        return this;
    }

    public List<String> getElements() {
        return elements;
    }
}
