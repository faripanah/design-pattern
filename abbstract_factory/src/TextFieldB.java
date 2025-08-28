public class TextFieldB extends  UIElement  {
    public TextFieldB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("ButtonB"+ text);
    }
}
