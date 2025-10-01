public class CityMap extends GameMap {

    public CityMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    protected Tile createTile() {
        // city: road, forest, building
        int pick = rnd.nextInt(3);
        switch (pick) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            default: return new BuildingTile();
        }
    }
}
