package view;
import controller.Controller;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//ColorBox knows only which box and which color the user clicked.
public class ColorBox {
    private int id; // the box number
    private Controller controller;
    private Rectangle rectangle;
    private Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};
    private int colorIndex = 0;

    public ColorBox(int id, Controller controller) {
        rectangle = new Rectangle(100, 100);
        rectangle.setFill(colors[colorIndex]);
        rectangle.setOnMouseClicked(event -> {
            changeColor();
            //“Hey Controller, the user clicked box number id, and its new color is colorIndex. Please save
            // the old state (for undo) and update the model with this new color.”
            controller.setOption(id, colorIndex);
        });
     }
    public Rectangle getRectangle() {
        return rectangle;
    }

    private void changeColor() {
        colorIndex = (colorIndex + 1) % colors.length;
        rectangle.setFill(colors[colorIndex]);
    }

    public void setColor(int colorIndex) {
        this.colorIndex = colorIndex;
        rectangle.setFill(colors[colorIndex]);
    }






}
