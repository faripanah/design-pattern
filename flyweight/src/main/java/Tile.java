public interface Tile {
    char getCharacter();
    String getType();

    default void action() {

    }
}
