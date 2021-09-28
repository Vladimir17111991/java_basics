package ru.skillbox;

public class Keyboard {
    private final double weight;
    private final String typeKeyboard;
    private final BacklightKeyboard backlightKeyboard;

    public Keyboard(String typeKeyboard, BacklightKeyboard backlightKeyboard,double weight) {
        this.weight = weight;
        this.typeKeyboard = typeKeyboard;
        this.backlightKeyboard = backlightKeyboard;
    }

    public double getWeight() {
        return weight;
    }

    public String getTypeKeyboard() {
        return typeKeyboard;
    }

    public BacklightKeyboard getBacklightKeyboard() {
        return backlightKeyboard;
    }
}
