import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Game extends Application {
    private static final int TILE_SIZE = 40;
    private GameMap map;


    public GameMap createMap(String kind, int rows, int cols) {
        if ("city".equalsIgnoreCase(kind)) {
            return new CityMap(rows, cols);
        } else {
            return new WildernessMap(rows, cols);
        }
    }

    @Override
    public void start(Stage primaryStage) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose map type (city/wilderness): ");
        String kind = sc.nextLine().trim();
        System.out.print("rows cols: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        map = createMap(kind, rows, cols);


        System.out.println("Textual map:");
        map.display();

        //  JavaFX Canvas
        Canvas canvas = new Canvas(cols * TILE_SIZE, rows * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        TileGraphicFactory gfxFactory = TileGraphicFactory.getInstance(TILE_SIZE);


        Tile[][] tiles = map.getTiles();
        for (int r = 0; r < map.getRows(); r++) {
            for (int c = 0; c < map.getCols(); c++) {
                Tile tile = tiles[r][c];
                Image img = gfxFactory.getGraphic(tile.getType()); // flyweight graphic shared
                gc.drawImage(img, c * TILE_SIZE, r * TILE_SIZE);
            }
        }

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RPG Map (" + kind + ")");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

