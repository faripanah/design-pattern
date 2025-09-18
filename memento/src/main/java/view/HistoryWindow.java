package view;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import controller.Controller;
import model.IMemento;
import java.util.List;

public class HistoryWindow {
    public static void show(Controller controller) {
        Stage stage = new Stage();
        List<IMemento> history = controller.getHistory();

        ListView<String> listView = new ListView<>();
        for (IMemento m : history) {
            listView.getItems().add(m.toString());
        }


        VBox root = new VBox(listView);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("History Window");
        stage.show();
    }
}
