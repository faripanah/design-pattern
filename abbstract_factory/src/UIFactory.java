//abstract factory
public interface UIFactory {
    Button  createButton(String text);
    TextField  createTextField(String text);
    Checkbox  createCheckbox(String text);
}


