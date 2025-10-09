import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pixelart.commands.*;
import pixelart.model.PixelGrid;
import pixelart.view.PixelGridView;

public class PixelArtApp extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Create the model (Receiver)
        PixelGrid model = new PixelGrid(8, 8);

        // 2. Create the view
        PixelGridView gridView = new PixelGridView(model);

        // 3. Connect model and view
        model.setOnChange(gridView::updateView);
        // ⬆️ Here you stop — this connects model updates to the GUI redraw.

        // 4. Create commands (Concrete Commands)
        Command moveUp = new MoveCursorUpCommand(model);
        Command moveDown = new MoveCursorDownCommand(model);
        Command moveLeft = new MoveCursorLeftCommand(model);
        Command moveRight = new MoveCursorRightCommand(model);
        Command togglePixel = new TogglePixelCommand(model);
        Command generateCode = new GenerateCodeCommand(model);

        // 5. Build GUI layout (Invoker setup)
        BorderPane root = new BorderPane();
        root.setCenter(gridView.createGrid());
        root.setBottom(gridView.createGenerateButton(generateCode));

        // 6. Keyboard controls (Invokers for movement/toggle)
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP -> moveUp.execute();
                case DOWN -> moveDown.execute();
                case LEFT -> moveLeft.execute();
                case RIGHT -> moveRight.execute();
                case SPACE -> togglePixel.execute();
            }
        });

        // 7. Show stage
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor (Command Pattern)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

