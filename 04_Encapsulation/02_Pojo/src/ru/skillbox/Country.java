package ru.skillbox;

public class Country {

    private String name;
    private int population;
    private int squareCountry;
    private String nameOfCapital;
    private boolean accessToSea;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSquareCountry() {
        return squareCountry;
    }

    public void setSquareCountry(int squareCountry) {
        this.squareCountry = squareCountry;
    }

    public String getNameOfCapital() {
        return nameOfCapital;
    }

    public void setNameOfCapital(String nameOfCapital) {
        this.nameOfCapital = nameOfCapital;
    }

    public boolean getAccessToSea() {
        return accessToSea;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.accessToSea = accessToSea;
    }
}
