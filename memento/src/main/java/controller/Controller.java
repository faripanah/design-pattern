package controller;
import model.*;
import view.GUI;
import java.util.ArrayList;
import java.util.List;
public class Controller {
    private Model model;
    private GUI gui;
    private List<IMemento> undoHistory; // Undo list
    private List<IMemento> redoHistory; // Redo list


    public Controller(GUI gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    // Save current state to undo
    private void saveToUndo() {
        undoHistory.add(model.createMemento());
        // Clear redo on new action(new change)
        redoHistory.clear();
    }

    //Before changing anything, it saves the current state (so you can undo).
    //Then it forwards the request to the Model
    public void setOption(int optionNumber, int choice) {
        //saveToHistory();
        saveToUndo();
        model.setOption(optionNumber, choice);// tell the model to update
    }
    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        //saveToHistory();
        saveToUndo();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            IMemento currentState = model.createMemento();
            undoHistory.add(currentState);
            IMemento previousState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento currentState = model.createMemento();
            undoHistory.add(currentState); // save for undo
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

   /* private void saveToHistory() {
        IMemento currentState = model.createMemento();
        undoHistory.add(currentState);

    }*/
   // For history window
   public List<IMemento> getHistory() {
       return new ArrayList<>(undoHistory); // copy to avoid modification
   }


}

