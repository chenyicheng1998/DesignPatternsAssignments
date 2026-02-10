public class NoviceState extends State {
    private static final int XP_TO_ADVANCE = 50;

    public NoviceState(GameCharacter character) {
        super(character);
        System.out.println("\n📘 Welcome to Novice level!");
        System.out.println("You need " + XP_TO_ADVANCE + " XP to advance to Intermediate level.");
    }

    @Override
    public void handleAction() {
        String[] options = {"Train"};
        int choice = character.readUserChoice(options);

        switch (choice) {
            case 1:
                train();
                break;
        }

        checkLevelUp(XP_TO_ADVANCE, new IntermediateState(character), "Intermediate");
    }

    private void train() {
        System.out.println("\n⚔️  Training...");
        System.out.println("You practice basic combat moves and study techniques.");
        int xpGained = 15 + (int)(Math.random() * 11); // 15-25 XP
        character.addExperiencePoints(xpGained);
    }
}

