public abstract class State {
    public Character character;

    public State(Character character) {
        this.character = character;
    }
    public abstract void action();
}
