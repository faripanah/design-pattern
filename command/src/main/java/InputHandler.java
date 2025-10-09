public class InputHandler {
    private Command up, down, left, right, toggle, generate;


    public InputHandler(Command up, Command down, Command left, Command right, Command toggle, Command generate) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.toggle = toggle;
        this.generate = generate;
    }


    public void pressUp() { up.execute(); }
    public void pressDown() { down.execute(); }
    public void pressLeft() { left.execute(); }
    public void pressRight() { right.execute(); }
    public void pressToggle() { toggle.execute(); }
    public void pressGenerate() { generate.execute(); }
}
