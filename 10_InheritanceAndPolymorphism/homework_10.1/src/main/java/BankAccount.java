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

  public void put(double amountToPut) {
    if(amountToPut>0)
    {
      summa +=amountToPut;
    }
    else
      System.out.println("Введено отрицательное число");
  }

  public void take(double amountToTake) {
    if (summa>=amountToTake)
    {
      summa -=amountToTake;
    }
    else {
      System.out.println("Недостаточно средств");
    }

  }

  public boolean send(BankAccount receiver,double amount)
  {
double commission=amount*1.01;
    if (summa>=commission) {
      take(commission);
      System.out.println("На счет "+receiver+" отправлено " + amount +"рубля");
      return true;
    }
    else
      return false;
  }
}
