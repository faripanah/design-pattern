import java.util.Random;
public abstract class Map {
    private int rows;
    private int cols;
    private char[][] map; // matrix of characters
    protected Random rand = new Random();
    public Map(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        map = new char[rows][cols];

    }
    public void display(){
       /*  // this just give me one random tile: Tile tile;
        tile= createTile(); */
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Tile t = createTile(); //create a tile
                map[i][j] = t.getCharacter();// store its character
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }
    public abstract Tile createTile(); // factory method



}
