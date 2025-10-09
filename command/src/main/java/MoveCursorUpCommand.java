public class MoveCursorUpCommand implements Command{
    private EditorModel model;

    public MoveCursorUpCommand(EditorModel model){
        this.model = model;
    }
    @Override
    public void execute() {
        model.moveUp();
    }




}
