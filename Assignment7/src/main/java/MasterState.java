public class MasterState extends State {

    public MasterState(GameCharacter character) {
        super(character);
        System.out.println("\n📙 Congratulations! You've reached Master level!");
        System.out.println("You are now a true master of combat!");
    }

    @Override
    public void handleAction() {
        // Master level is the final state, no more actions needed
        // The game will end when this state is reached
    }
}

