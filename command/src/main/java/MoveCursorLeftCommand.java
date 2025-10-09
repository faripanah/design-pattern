public class MoveCursorLeftCommand implements Command {
    private EditorModel model;
    public MoveCursorLeftCommand(EditorModel model) {
        this.model = model;
    }
    @Override
    public void execute() {
        model.moveLeft();
    }
}
