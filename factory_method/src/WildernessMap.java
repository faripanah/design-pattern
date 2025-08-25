import java.util.Random;

public class WildernessMap extends Map {
    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }
    @Override
    public Tile createTile(){
        int choice = rand.nextInt(3);
        switch (choice){
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            case 2: return new ForestTile();
        }
        return null;
    }
}
