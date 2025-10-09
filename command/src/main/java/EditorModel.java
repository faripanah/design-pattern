public class EditorModel {
    public static final int SIZE = 8;
    private boolean[][] grid = new boolean[SIZE][SIZE];
    private int cursorX = 0;
    private int cursorY = 0;
    private Runnable onChange;


    public EditorModel() {

    }


    public void setOnChange(Runnable r) {
        this.onChange = r;
    }


    private void changed() {
        if (onChange != null) onChange.run();
    }

    public void moveUp() {
        if (cursorY > 0) cursorY--;
        changed();
    }


    public void moveDown() {
        if (cursorY < SIZE - 1) cursorY++;
        changed();
    }


    public void moveLeft() {
        if (cursorX > 0) cursorX--;
        changed();
    }


    public void moveRight() {
        if (cursorX < SIZE - 1) cursorX++;
        changed();
    }


    public void moveTo(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            cursorX = x;
            cursorY = y;
            changed();
        }
    }


    public void toggle() {
        grid[cursorY][cursorX] = !grid[cursorY][cursorX];
        changed();
    }


    public boolean isOn(int row, int col) {
        return grid[row][col];
    }


    public int getCursorX() { return cursorX; }
    public int getCursorY() { return cursorY; }


    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int r = 0; r < SIZE; r++) {
            sb.append(" {");
            for (int c = 0; c < SIZE; c++) {
                sb.append(grid[r][c] ? "1" : "0");
                if (c < SIZE - 1) sb.append(", ");
            }
            sb.append("}");
            if (r < SIZE - 1) sb.append(",\n"); else sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }

}
