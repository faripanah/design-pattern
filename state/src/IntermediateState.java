public class IntermediateState extends State {
    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate"};
        int choice = character.readChoice(options);

        switch (choice) {
            case 1:
                character.addExp(15);
                break;
            case 2:
                character.addHealth(10);
                break;
        }
        if (character.getExp() >= 50) {
            character.levelUp();
            character.setState(new ExpertState(character));
        }

    }
}
