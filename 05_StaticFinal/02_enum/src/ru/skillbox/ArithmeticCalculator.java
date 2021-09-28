package ru.skillbox;

public class ArithmeticCalculator {
    private final int perem1;
    private final int perem2;

    public ArithmeticCalculator(int perem1, int perem2) {
        this.perem1 = perem1;
        this.perem2 = perem2;
    }
    public int calculate(Operation operation) {
        if (operation == Operation.MULTIPLY) {
            return perem1 * perem2;
        }
        else
        if (operation == Operation.ADD) {
            return perem1 + perem2;
        }
        else
            return perem1 - perem2;
    }
}
