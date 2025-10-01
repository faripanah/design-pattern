import java.util.Random;

public abstract class GameMap {
    protected final int rows;
    protected final int cols;
    protected final Tile[][] tiles;
    protected final Random rnd = new Random();

    public GameMap(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[rows][cols];
        generate();
    }

    // factory method
    protected abstract Tile createTile();

    //  factory method
    protected void generate() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                tiles[r][c] = createTile();
            }
        }
    }


    public void display() {
        for (int r = 0; r < rows; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                sb.append(tiles[r][c].getCharacter()).append(' ');
            }
            System.out.println(sb.toString());
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
