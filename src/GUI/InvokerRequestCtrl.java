package GUI;

public class InvokerRequestCtrl {
    iCommand command;
    public void setCommand(iCommand command) {
        this.command = command;
    }
    public void doExecute() {
        command.executeRequest();
    }
}
