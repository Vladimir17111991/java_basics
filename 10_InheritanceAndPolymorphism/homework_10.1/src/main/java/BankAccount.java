public class BankAccount {
    private double summa;
    private double amountToPut;
    private double amountToTake;

    public double getAmount() {
        return summa;
    }

    public double getAmountToPut() {
        return amountToPut;
    }

    public void setAmountToPut(double amountToPut) {
        this.amountToPut = amountToPut;
    }

    public double getAmountToTake() {
        return amountToTake;
    }

    public void setAmountToTake(double amountToTake) {
        this.amountToTake = amountToTake;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public boolean put(double amountToPut) {
        if (amountToPut > 0) {
            summa += amountToPut;
            return true;
        } else
            System.out.println("Введено отрицательное число");
        return false;
    }

    public boolean take(double amountToTake) {
        if (summa >= amountToTake && summa > 0) {
            summa -= amountToTake;
            return true;
        } else {
            System.out.println("Недостаточно средств");
            return false;
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        double commission = amount * 1.01;
        boolean isPut = receiver.put(amount);
        if (isPut) {
            return true;
        }
        boolean isTake = receiver.take(commission);
        if (isTake) {
            return true;
        }
        return false;
    }
}
