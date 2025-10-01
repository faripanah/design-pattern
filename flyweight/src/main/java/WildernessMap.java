public class WildernessMap extends GameMap {

    public WildernessMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        // wilderness: swamp, water, forest
        int pick = rnd.nextInt(3);
        switch (pick) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            default: return new ForestTile();
        }
    }
}
