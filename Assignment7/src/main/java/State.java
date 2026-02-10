public abstract class State {
    protected GameCharacter character;

    public State(GameCharacter character) {
        this.character = character;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    // Abstract method to handle actions in each state
    public abstract void handleAction();

    // Common method to check and handle level progression
    protected void checkLevelUp(int requiredXP, State nextState, String nextLevelName) {
        if (character.getExperiencePoints() >= requiredXP) {
            System.out.println("\n🎊 LEVEL UP! 🎊");
            System.out.println("You've advanced to " + nextLevelName + "!");
            character.setLevel(character.getLevel() + 1);
            character.setState(nextState);
        }
    }
}

