package ru.skillbox;

public class Main {
    public static void main(String[] args) {


        Dimensions dimensions = new Dimensions(54.7, 23.9, 52.4);
        Cargo cargo = new Cargo(dimensions, 15, "Minsk", "54357PB423423");
        Cargo copy = new Cargo(cargo.getDimensions(),
                cargo.getWeight(),
                cargo.getAdressDeliv(),
                cargo.getRegNumber()
        );
    }
}
