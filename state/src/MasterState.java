public class MasterState extends State{
    public MasterState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        System.out.println("Game finished!!!");
    }
}
