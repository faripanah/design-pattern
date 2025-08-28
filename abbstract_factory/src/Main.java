// client
public class Main {
    public static void main(String[] args) {
        //  Style A
        UIFactory factory = new AFactory();

        UIElement btn = factory.createButton("Click Me!");
        UIElement txt = factory.createTextField("Enter name");
        UIElement chk = factory.createCheckbox("Accept terms");

        btn.display();
        txt.display();
        chk.display();

        //  style B
        factory = new BFactory();
        UIElement btn2 = factory.createButton("Press");
        UIElement txt2 = factory.createTextField("Type here");
        UIElement chk2 = factory.createCheckbox("Subscribe");

        btn2.display();
        txt2.display();
        chk2.display();

        }
    }
