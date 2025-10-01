import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.HashMap;
import java.util.Map;


public class TileGraphicFactory {
    private static TileGraphicFactory instance;
    private final Map<String, Image> cache = new HashMap<>();
    private final int tileSize;

    private TileGraphicFactory(int tileSize) {
        this.tileSize = tileSize;
    }

    public static TileGraphicFactory getInstance(int tileSize) {
        if (instance == null) {
            instance = new TileGraphicFactory(tileSize);
        }
        return instance;
    }

    public Image getGraphic(String type) {
        if (cache.containsKey(type)) return cache.get(type);


        Canvas canvas = new Canvas(tileSize, tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        switch (type) {
            case "swamp":
                gc.setFill(Color.DARKGREEN.darker());
                gc.fillRect(0, 0, tileSize, tileSize);
                drawSymbol(gc, "S");
                break;
            case "water":
                gc.setFill(Color.DEEPSKYBLUE);
                gc.fillRect(0, 0, tileSize, tileSize);
                drawSymbol(gc, "W");
                break;
            case "road":
                gc.setFill(Color.SANDYBROWN);
                gc.fillRect(0, 0, tileSize, tileSize);
                gc.setFill(Color.DARKGRAY);
                gc.fillRect(tileSize*0.2, tileSize*0.4, tileSize*0.6, tileSize*0.2);
                drawSymbol(gc, "R");
                break;
            case "forest":
                gc.setFill(Color.FORESTGREEN);
                gc.fillRect(0, 0, tileSize, tileSize);
                drawSymbol(gc, "F");
                break;
            case "building":
                gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(0, 0, tileSize, tileSize);
                gc.setFill(Color.DIMGRAY);
                gc.fillRect(tileSize*0.15, tileSize*0.15, tileSize*0.7, tileSize*0.7);
                drawSymbol(gc, "B");
                break;
            default:
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, tileSize, tileSize);
                drawSymbol(gc, "?");
                break;
        }

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image image = canvas.snapshot(params, null);

        cache.put(type, image);
        return image;
    }

    private void drawSymbol(GraphicsContext gc, String symbol) {
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(tileSize * 0.45));
        gc.fillText(symbol, tileSize * 0.18, tileSize * 0.72);
    }
}

