//concrete products
public class ButtonA extends UIElement {
    public ButtonA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("ButtonA");
        System.out.println(text);
    }
}
