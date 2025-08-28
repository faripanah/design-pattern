public class CheckboxA extends UIElement {
    public CheckboxA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("CheckBoxA" + text);
    }
}
