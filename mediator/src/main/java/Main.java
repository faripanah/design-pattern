import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChatMediator mediator = new ChatRoom();

        new ChatClientController("Ali", mediator);
        new ChatClientController("Sara", mediator);
        new ChatClientController("Reza", mediator);

    }
    public static void main(String[] args) {
        launch(args);
    }

}
