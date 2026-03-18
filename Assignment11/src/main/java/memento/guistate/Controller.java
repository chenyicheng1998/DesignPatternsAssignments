package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> undoHistory;  // List to store states for undo
    private List<IMemento> redoHistory;  // List to store states for redo

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToUndoHistory();
        clearRedoHistory();  // Clear redo history when a new change is made
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToUndoHistory();
        clearRedoHistory();  // Clear redo history when a new change is made
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    // Undo functionality: Ctrl+Z
    public void undo() {
        if (!undoHistory.isEmpty()) {
            System.out.println("Undo: Memento found in undo history");
            // Save current state to redo history before undoing
            IMemento currentState = model.createMemento();
            redoHistory.add(currentState);
            
            // Restore previous state from undo history
            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
            gui.updateHistoryDisplay();
        }
    }

    // Redo functionality: Ctrl+Y
    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo: Memento found in redo history");
            // Save current state to undo history before redoing
            IMemento currentState = model.createMemento();
            undoHistory.add(currentState);
            
            // Restore state from redo history
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
            gui.updateHistoryDisplay();
        }
    }

    private void saveToUndoHistory() {
        IMemento currentState = model.createMemento();
        undoHistory.add(currentState);
    }

    private void clearRedoHistory() {
        redoHistory.clear();
    }

    // Get the undo history list for the history window
    public List<IMemento> getUndoHistory() {
        return new ArrayList<>(undoHistory);
    }

    // Restore to a specific memento from history
    public void restoreToMemento(IMemento memento) {
        // Clear redo history when jumping to a specific state
        redoHistory.clear();
        model.restoreState(memento);
        gui.updateGui();
        gui.updateHistoryDisplay();
    }
}

