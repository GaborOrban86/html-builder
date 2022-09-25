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
    Scanner scanner = new Scanner(System.in);

    public void htmlStringMaker(String[] arr) {
        if (arr.length < 2) {
            html = "A szükséges adatokat meg kell adni!";
        } else {
            html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "    <head>\n" +
                    "        <title>Teszt Feladat</title>\n" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "        <h1>Teszt Feladat</h1>\n" +
                    "        <p><a href=\"" + repositoryUrl + "\">Megoldás</a></p>\n" +
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
                    "</html>";
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
        html = finalStringBuilder.toString();
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

    public void htmlAppRun(String repository, String[] arr) {
        repositoryUrl = repository;
        int choose;
        String element;
        boolean button = false;

        if (arr.length < 2) {
            arr = new String[2];
            System.out.println("Kérjük, hogy adja meg a nevét!");
            arr[0] = scanner.nextLine();
            System.out.println("Kérjük, hogy adja meg az e-mail címét!");
            arr[1] = scanner.nextLine();
        }

        htmlStringMaker(arr);
        System.out.println("Html fájl létrehozva!");

        do {
            System.out.println("Szeretne törölni elemet a véglegesítés előtt?");
            System.out.println("1 - Igen");
            System.out.println("2 - Nem");
            choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    System.out.println("Írd be a törölni kívánt elemet (h1, p, a, table, tr vagy td):");
                    element = scanner.nextLine();
                    if (!elements.contains(element)) {
                        System.out.println("Rossz bemenet!");
                    } else {
                        deleteLines(html, element);
                        button = true;
                        System.out.println("Html fájl sikeresen létrehozva az alábbi tartalommal:");
                        htmlFileMaker(html);
                    }
                    break;
                case 2:
                    button = true;
                    System.out.println("Html fájl sikeresen létrehozva az alábbi tartalommal:");
                    htmlFileMaker(html);
                    break;
                default:
                    System.out.println("Rossz bemenet!");
            }
        } while (!button);
    }
}