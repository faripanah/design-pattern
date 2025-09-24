import java.util.ArrayList;
import java.util.List;
//product class
public class Computer {
    private List<Component> components;

    public Computer() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Computer Configuration:\n");
        for (Component component : components) {
            sb.append("- ");
            sb.append(component.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
}
