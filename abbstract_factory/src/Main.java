// client
public class Main {
    public static void main(String[] args) {
        //  Style A
        UIFactory factory = new AFactory();

        Button btn = factory.createButton("Click Me!");
        TextField txt = factory.createTextField("Enter name");
        Checkbox chk = factory.createCheckbox("Accept terms");

        btn.display();
        txt.display();
        chk.display();

        //  style B
        factory = new BFactory();
        Button btn2 = factory.createButton("Press");
        TextField txt2 = factory.createTextField("Type here");
        Checkbox chk2 = factory.createCheckbox("Subscribe");

        btn2.display();
        txt2.display();
        chk2.display();

        }
    }
