package application;

public class CommandRequest {
    private String commandAction;
    private int commandId;
    public CommandRequest(String command) { // "command?id=#"
        String[] commandCodesUsingId = {"delete", "modify"};

        String[] commandCodes = command.split("\\?", 2); // "command?id=#" => {"command", "id=#"}
        this.commandAction = commandCodes[0]; // "command"

        if (commandCodes.length == 1) {
            for (String commandCodeUsingId : commandCodesUsingId) {
                if (commandCodeUsingId.equals(this.commandAction)) {
                    System.out.printf("Please enter the %s command with id parameter. (e.g. %s => %s?id=1)\n", this.commandAction, command, this.commandAction);
                    this.commandId = -1;
                }
            }
            return;
        }

        String[] commandParameter = commandCodes[1].split("=", 2); // {"id", "#"}

        if (commandParameter.length == 1 || commandParameter[1].equals("")) {
            System.out.printf("Please enter the %s command with id value. (e.g. %s => %s?id=1)\n", this.commandAction, command, this.commandAction);
            this.commandId = -1;
            return;
        }

        try {
            this.commandId = Integer.parseInt(commandParameter[1]); // "#"
        } catch (NumberFormatException e) {
            System.out.printf("Please enter the %s command with id as integer type. (e.g. %s => %s?id=1)\n", this.commandAction, command, this.commandAction);
            this.commandId = -1;
        }
    }

    public String getCommandAction() {
        return this.commandAction;
    }

    public int getCommandId() {
        return this.commandId;
    }
}
