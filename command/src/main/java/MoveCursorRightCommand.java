public class MoveCursorRightCommand implements Command {
    private EditorModel model;
    public MoveCursorRightCommand(EditorModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.moveRight();
    }
}
