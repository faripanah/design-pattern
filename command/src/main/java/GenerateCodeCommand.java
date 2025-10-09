public class GenerateCodeCommand implements Command {
    private EditorModel model;

    public GenerateCodeCommand(EditorModel model) {
        this.model = model;
    }

    @Override
    public void execute() {
        String code = model.generateJavaCode();
        System.out.println(code); // چاپ در کنسول
    }
}