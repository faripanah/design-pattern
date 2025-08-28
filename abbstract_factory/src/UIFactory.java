//abstract factory
public interface UIFactory {
    UIElement  createButton(String text);
    UIElement  createTextField(String text);
    UIElement  createCheckbox(String text);
}


