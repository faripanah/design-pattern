//concrete factory
public class BFactory implements UIFactory{
    @Override
    public UIElement createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public UIElement createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public UIElement createCheckbox(String text) {
        return new CheckboxB(text);
    }

}
