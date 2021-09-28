package ru.skillbox;

public class Processor {
    private final int freqProcessor;
    private final int numberCores;
    private final String vendor;
    private final double weight;

    public Processor(int freqProcessor, int numberCores, String vendor, double weight) {
        this.freqProcessor = freqProcessor;
        this.numberCores = numberCores;
        this.vendor = vendor;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getFreqProcessor() {
        return freqProcessor;
    }

    public int getNumberCores() {
        return numberCores;
    }

    public String getVendor() {
        return vendor;
    }
}
