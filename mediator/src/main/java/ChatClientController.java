//concrete client
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class ChatClientController implements ChatClient {

    private String username;
    private ChatMediator mediator;
    private TextArea messageArea;
    private TextField inputField;
    private TextField toUserField;
    private TextField fromUserField;

    public ChatClientController(String username, ChatMediator mediator) {

        this.username = username;
        this.mediator = mediator;
        //mediator.registerClient(ChatClient client);
        initUI();

    }
    private void initUI() {

        Stage stage = new Stage();

        stage.setTitle(username);
        messageArea = new TextArea();
        messageArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("enter message");

        fromUserField = new TextField();
        fromUserField.setPromptText("message sender");

        toUserField = new TextField();
        toUserField.setPromptText("message receiver");



        Button sendButton = new Button("send");
        sendButton.setOnAction(e -> {

            String message = inputField.getText();
            String fromUser = fromUserField.getText();
            String toUser = toUserField.getText();

            if (!message.isEmpty() && !toUser.isEmpty()) {

                sendMessage(message, fromUser, toUser);

                inputField.clear();

            }

        });

        VBox root = new VBox(10, new Label("messages:"), messageArea,
                new Label("send to:"), toUserField, inputField, sendButton);

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void sendMessage(String message, String fromUser, String toUser) {
        mediator.sendMessage(message, username, toUser);

    }

    @Override
    public void recieveMessage(String message) {
        messageArea.appendText(message + "\n");
    }

    @Override
    public String getUsername() {
        return username;

    }

}
