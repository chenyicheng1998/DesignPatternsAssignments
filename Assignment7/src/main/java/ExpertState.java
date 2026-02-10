public class ExpertState extends State {
    private static final int XP_TO_ADVANCE = 200;
    private static final int MIN_HP_TO_FIGHT = 20;

    public ExpertState(GameCharacter character) {
        super(character);
        System.out.println("\n📕 You've reached Expert level!");
        System.out.println("New ability unlocked: Fight");
        System.out.println("You need " + XP_TO_ADVANCE + " XP to advance to Master level.");
    }

    @Override
    public void handleAction() {
        String[] options = {"Train", "Meditate", "Fight"};
        int choice = character.readUserChoice(options);

        switch (choice) {
            case 1:
                train();
                break;
            case 2:
                meditate();
                break;
            case 3:
                fight();
                break;
        }

        checkLevelUp(XP_TO_ADVANCE, new MasterState(character), "Master");
    }

    private void train() {
        System.out.println("\n⚔️  Training...");
        System.out.println("You master complex combat techniques.");
        int xpGained = 10 + (int)(Math.random() * 11); // 10-20 XP
        character.addExperiencePoints(xpGained);
    }

    private void meditate() {
        System.out.println("\n🧘 Meditating...");
        System.out.println("You achieve deep meditation and rejuvenate your body.");
        int hpGained = 20 + (int)(Math.random() * 11); // 20-30 HP
        character.addHealthPoints(hpGained);

        int xpGained = 5 + (int)(Math.random() * 6); // 5-10 XP
        character.addExperiencePoints(xpGained);
    }

    private void fight() {
        if (character.getHealthPoints() < MIN_HP_TO_FIGHT) {
            System.out.println("\n❌ You don't have enough health to fight!");
            System.out.println("You need at least " + MIN_HP_TO_FIGHT + " HP. Consider meditating first.");
            return;
        }

        System.out.println("\n⚔️  Fighting a powerful enemy...");

        // Random outcome
        double successRate = 0.7; // 70% chance of success
        boolean victory = Math.random() < successRate;

        if (victory) {
            System.out.println("🏆 Victory! You defeated the enemy!");
            int xpGained = 25 + (int)(Math.random() * 16); // 25-40 XP
            int hpLost = 10 + (int)(Math.random() * 11); // 10-20 HP
            character.addExperiencePoints(xpGained);
            character.reduceHealthPoints(hpLost);
        } else {
            System.out.println("💥 Defeat! The enemy was too strong!");
            int xpGained = 10 + (int)(Math.random() * 6); // 10-15 XP (consolation)
            int hpLost = 20 + (int)(Math.random() * 11); // 20-30 HP
            character.addExperiencePoints(xpGained);
            character.reduceHealthPoints(hpLost);
        }

        if (character.getHealthPoints() <= 0) {
            System.out.println("\n⚠️  Warning: Your health is critical! Meditate to recover!");
        }
    }
}

