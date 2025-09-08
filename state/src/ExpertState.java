public class ExpertState extends State{
    public ExpertState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate", "Fight"};
        int choice = character.readChoice(options);

        switch (choice) {
            case 1:
                character.addExp(20);
                break;
            case 2:
                character.addHealth(15);
                break;
            case 3:
                character.reduceHealth(20);
                character.addExp(25);
                break;
        }

        if (character.getExp() >= 100) {
            character.levelUp();
            character.setState(new MasterState(character));
        }
    }
}
