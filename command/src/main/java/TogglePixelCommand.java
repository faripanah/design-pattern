public class TogglePixelCommand implements Command {
    private EditorModel model;
    public TogglePixelCommand(EditorModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        model.toggle();
    }
}
