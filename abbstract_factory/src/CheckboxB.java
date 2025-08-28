//concrete product for B
public class CheckboxB extends Checkbox {

    //constructor
    public CheckboxB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("CheckBoxB"+ text);
    }
}
