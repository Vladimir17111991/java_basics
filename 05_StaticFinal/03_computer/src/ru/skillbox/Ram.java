package ru.skillbox;

public class Ram {
    private final String typeRam;
    private final int sizeRam;
    private final double weight;

    public Ram(String typeRam, int sizeRam, double weight) {
        this.typeRam = typeRam;
        this.sizeRam = sizeRam;
        this.weight = weight;
    }

    public String getTypeRam() {
        return typeRam;
    }

    public int getSizeRam() {
        return sizeRam;
    }

    public double getWeight() {
        return weight;
    }
}
