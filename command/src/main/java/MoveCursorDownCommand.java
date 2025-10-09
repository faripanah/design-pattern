public class MoveCursorDownCommand implements Command {
    private EditorModel model;

    public MoveCursorDownCommand(EditorModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveDown();
    }
}