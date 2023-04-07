package application.system.controller;

import application.Container;

public class SystemController {
    public void init() {
        System.out.println("=".repeat(31));
        System.out.println("== Famous Saying Application ==");
        this.help();
    }
    public String getCommand() {
        System.out.println("=".repeat(31));
        System.out.printf("Command: ");
        return Container.getScanner().nextLine().trim().toLowerCase();
    }
    public void terminate() {
        System.out.println("=".repeat(31));
        System.out.println("Application has been terminated.");
    }
    public void help() {
        System.out.println("=".repeat(31));
        System.out.println("1. record");
        System.out.println("2. list");
        System.out.println("3. delete");
        System.out.println("4. modify");
        System.out.println("0. terminate");
    }
    public void error() {
        System.out.println("=".repeat(31));
        System.out.println("Please enter the valid command. If you want to know commands, then enter \"help\".");
    }
}
