package ru.skillbox;

public class HardwareDisk {
    private final TypeHardDisk typeHardDisk;
    private final int memory;
    private final double weight;

    public HardwareDisk(TypeHardDisk typeHardDisk, int memory, double weight) {
        this.typeHardDisk = typeHardDisk;
        this.memory = memory;
        this.weight = weight;
    }

    public TypeHardDisk getTypeHardDisk() {
        return typeHardDisk;
    }

    public int getMemory() {
        return memory;
    }

    public double getWeight() {
        return weight;
    }
}
