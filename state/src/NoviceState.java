public class NoviceState extends State {
    //constructor
    public NoviceState(Character character) {
        super(character);


        public void action(){
            String[] options = {"Train"};
            int choice = character.readChoice(options);

            if (choice == 1) {
                character.addExp(10);
                if (character.getExp() >= 20) {
                    character.levelUp();
                    character.setState(new IntermediateState(character));
                }
            }
        }
    }

}
