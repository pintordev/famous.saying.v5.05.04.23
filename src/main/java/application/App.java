package application;

import application.famousSaying.controller.FamousSayingController;
import application.system.controller.SystemController;

public class App {
    public static void run() {
        SystemController systemController = new SystemController();
        FamousSayingController famousSayingController = new FamousSayingController();


        systemController.init();

        while (true) {
            CommandRequest commandRequest = new CommandRequest(systemController.getCommand());

            switch (commandRequest.getCommandAction()) {
                case "terminate":
                    systemController.terminate();
                    return;
                case "record":
                    famousSayingController.record();
                    break;
                case "list":
                    famousSayingController.list();
                    break;
                case "delete":
                    famousSayingController.delete(commandRequest.getCommandId());
                    break;
                case "modify":
                    famousSayingController.modify(commandRequest.getCommandId());
                    break;
                case "help":
                    systemController.help();
                    break;
                default:
                    systemController.error();
                    break;
            }
        }
    }
}
