package application.famousSaying.controller;

import application.Container;
import application.Util;
import application.famousSaying.entity.FamousSaying;
import application.famousSaying.service.FamousSayingService;

import java.util.List;

public class FamousSayingController {
    FamousSayingService sayingService;

    public FamousSayingController() {
        this.sayingService = new FamousSayingService();
    }

    public void record() {
        System.out.println("=".repeat(31));
        System.out.printf("Famous Saying: ");
        String contents = Container.getScanner().nextLine().trim();
        System.out.printf("Author: ");
        String author = Container.getScanner().nextLine().trim();

        int id = this.sayingService.record(author, contents);

        System.out.printf("%s famous saying has been recorded.\n", Util.ordinal(id));
    }

    public void list() {
        List<FamousSaying> sayingList = this.sayingService.getSayingList();

        System.out.println("=".repeat(31));
        if (sayingList.size() > 0) {
            System.out.println("Id / Author / Contents");
            System.out.println("-".repeat(27));
            for (int i = sayingList.size() - 1; i >= 0; i--) {
                System.out.println(sayingList.get(i).getList());
            }
        } else {
            System.out.println("There is no list in this application. Try record!");
        }
    }

    public void delete(int commandId) {
        if (commandId == -1) return;

        System.out.println("=".repeat(31));

        FamousSaying famousSaying = this.sayingService.findById(commandId);

        if (famousSaying != null) {
            this.sayingService.delete(famousSaying);
            System.out.printf("%s famous saying has been deleted.\n", Util.ordinal(commandId));
        } else {
            System.out.printf("%s famous saying does not exist.\n", Util.ordinal(commandId));
        }
    }

    public void modify(int commandId) {
        if (commandId == -1) return;

        System.out.println("=".repeat(31));

        FamousSaying famousSaying = this.sayingService.findById(commandId);

        if (famousSaying != null) {
            System.out.printf("Famous Saying (present): %s\n", famousSaying.getContents());
            System.out.printf("Famous Saying (to be modified): ");
            String contents = Container.getScanner().nextLine().trim();

            System.out.println("=".repeat(31));
            System.out.printf("Author (present): %s\n", famousSaying.getAuthor());
            System.out.printf("Author (to be modified): ");
            String author = Container.getScanner().nextLine().trim();

            System.out.println("=".repeat(31));
            this.sayingService.modify(famousSaying, author, contents);
            System.out.printf("%s famous saying has been modified.\n", Util.ordinal(commandId));
        } else {
            System.out.printf("%s famous saying does not exist.\n", Util.ordinal(commandId));
        }
    }
}
