//concrete product for style B
public class TextFieldB extends  TextField  {

    //constructor
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("ButtonB"+ text);
    }
}
