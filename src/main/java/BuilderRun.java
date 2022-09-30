import elements.Html;

import java.util.Scanner;

public class BuilderRun {

    Scanner scanner = new Scanner(System.in);
    EveryThingToRun everyThingToRun = new EveryThingToRun();
    BuilderService service = new BuilderService();

    public void htmlAppRun(String repository, String[] arr) {

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

        Html finalHtml = everyThingToRun.setEverything(repository, arr);
        service.setHtmlString(finalHtml.toString());
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
                    if (!service.getElements().contains(element)) {
                        System.out.println("Rossz bemenet!");
                    } else {
                        service.deleteHtmlElements(everyThingToRun.getFinalHtml(), element);
                        button = true;
                        System.out.println("Html fájl sikeresen létrehozva az alábbi tartalommal:");
                        service.htmlFileMaker(service.getHtmlString());
                    }
                    break;
                case 2:
                    button = true;
                    System.out.println("Html fájl sikeresen létrehozva az alábbi tartalommal:");
                    service.htmlFileMaker(service.getHtmlString());
                    break;
                default:
                    System.out.println("Rossz bemenet!");
            }
        } while (!button);
    }
}
