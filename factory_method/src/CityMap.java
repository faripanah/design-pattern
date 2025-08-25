public class CityMap extends Map {
    public CityMap(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);
        switch (choice){
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
        }
        return null;
    }
}
