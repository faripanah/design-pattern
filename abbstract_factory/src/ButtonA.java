//concrete products for style A
public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("ButtonA");
        System.out.println(text);
    }
}
