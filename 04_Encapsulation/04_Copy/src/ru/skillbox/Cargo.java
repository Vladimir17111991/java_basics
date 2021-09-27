package ru.skillbox;

public class Cargo {
    private final Dimensions dimensions;
    private final double weight;
    private final String adressDeliv;
    // private final boolean coupCargo;
    private final String regNumber;
    // private final boolean fragileCargo;

    public Cargo(Dimensions dimensions, double weight, String adressDeliv, String regNumber) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.adressDeliv = adressDeliv;
        boolean coupCargo = false;
        this.regNumber = regNumber;
        boolean fragileCargo1 = false;
    }


    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions,weight,adressDeliv,regNumber);
    }
    public Cargo setWeight(double weight) {
        return new Cargo(dimensions,weight,adressDeliv,regNumber);
    }
    public Cargo setAdressDeliv(String adressDeliv) {
        return new Cargo(dimensions,weight,adressDeliv,regNumber);
    }
    public Cargo setRegNumber(String regNumber) {
        return new Cargo(dimensions,weight,adressDeliv,regNumber);
    }

    public Dimensions getDimensions() { return dimensions; }
    public double getWeight() {
        return weight;
    }
    public String getAdressDeliv() {
        return adressDeliv;
    }
    public String getRegNumber() {
        return regNumber;
    }
}
