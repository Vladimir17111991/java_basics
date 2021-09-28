package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(7,2);

        System.out.println("Умножение чисел - " + arithmeticCalculator.calculate(Operation.MULTIPLY));
        System.out.println("Сложение чисел - " + arithmeticCalculator.calculate(Operation.ADD));
        System.out.println("Вычитание чисел - " + arithmeticCalculator.calculate(Operation.SUBTRACT));
    }
}
