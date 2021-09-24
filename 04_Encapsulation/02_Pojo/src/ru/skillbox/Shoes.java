package ru.skillbox;

public class Shoes {
    private int size;
    private String material;
    private String nameModel;
    private boolean typeShoes; // м или ж


    public Shoes(int size, String nameModel) {
        this.size = size;
        this.nameModel = nameModel;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public boolean getTypeShoes() {
        return typeShoes;
    }

    public void setTypeShoes(boolean typeShoes) {
        this.typeShoes = typeShoes;
    }
}
