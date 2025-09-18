package model;

import java.time.LocalDateTime;
//memento
public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private final LocalDateTime savedTime;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone();
        this.isSelected = isSelected;
        this.savedTime = LocalDateTime.now(); // store timestamp
        System.out.println("Memento created at " + savedTime);
    }
    public int[] getOptions() {
        return options;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public LocalDateTime getSavedTime() {
        return savedTime;
    }
    @Override
    public String toString() {
        return "Options: [" + options[0] + "," + options[1] + "," + options[2] + "], " +
                "Selected: " + isSelected + ", Time: " + savedTime.toLocalTime();
    }
}
