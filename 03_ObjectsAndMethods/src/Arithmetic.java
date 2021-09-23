public class Arithmetic {
    private int variable1;
    private int variable2;

    public Arithmetic(int variable1, int variable2) {
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public int sumOfNumbers() {
        return variable1 + variable2;
    }

    public int multiplyOfNumbers() {
        return variable1 * variable2;
    }

    public int maxOfNumbers() {
        return Math.max(variable1, variable2);
    }

    public int minOfNumbers() {
        return Math.min(variable1, variable2);
    }
}