public class IntermediateState extends State {
    private static final int XP_TO_ADVANCE = 120;

    public IntermediateState(GameCharacter character) {
        super(character);
        System.out.println("\n📗 You've reached Intermediate level!");
        System.out.println("New ability unlocked: Meditate");
        System.out.println("You need " + XP_TO_ADVANCE + " XP to advance to Expert level.");
    }

    @Override
    public void handleAction() {
        String[] options = {"Train", "Meditate"};
        int choice = character.readUserChoice(options);

        switch (choice) {
            case 1:
                train();
                break;
            case 2:
                meditate();
                break;
        }

        checkLevelUp(XP_TO_ADVANCE, new ExpertState(character), "Expert");
    }

    private void train() {
        System.out.println("\n⚔️  Training...");
        System.out.println("You practice advanced combat techniques.");
        int xpGained = 12 + (int)(Math.random() * 9); // 12-20 XP
        character.addExperiencePoints(xpGained);
    }

    private void meditate() {
        System.out.println("\n🧘 Meditating...");
        System.out.println("You focus your mind and restore your energy.");
        int hpGained = 15 + (int)(Math.random() * 11); // 15-25 HP
        character.addHealthPoints(hpGained);

        // Also gain a small amount of XP from meditation
        int xpGained = 3 + (int)(Math.random() * 5); // 3-7 XP
        character.addExperiencePoints(xpGained);
    }
}

