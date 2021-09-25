package ru.skillbox;

public class Shoes {
    private int size;
    private String material;
    private String nameModel;
    private TypeShoes type; // м или ж


    public TypeShoes getType() {
        return type;
    }

    public void setType(TypeShoes type) {
        this.type = type;
    }


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

}
