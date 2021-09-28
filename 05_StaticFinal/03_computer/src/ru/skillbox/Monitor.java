package ru.skillbox;

public class Monitor {
    private final int diagonal;
    private final TypeMonitor typeMonitor;
    private final double weight;

    public Monitor(int diagonal, TypeMonitor typeMonitor, double weight) {
        this.diagonal = diagonal;
        this.typeMonitor = typeMonitor;
        this.weight = weight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public TypeMonitor getTypeMonitor() {
        return typeMonitor;
    }

    public double getWeight() {
        return weight;
    }
}
