public abstract class Client {
private double currentSumma;
    public double getAmount() {
        return currentSumma;
    }

    public void put(double amountToPut) {
        if(amountToPut>0)
        {
            currentSumma += amountToPut;
        }
        else
            System.out.println("Введено отрицательное значение");

    }

    public void take(double amountToTake) {
    if (amountToTake>currentSumma)
    {
        System.out.println("Введеное число превышает сумму на счете");
    }
    else
        currentSumma -=amountToTake;
    }
    public abstract void info();
}
