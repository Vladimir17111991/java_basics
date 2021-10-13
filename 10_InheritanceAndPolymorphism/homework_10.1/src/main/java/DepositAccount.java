import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    LocalDate lastIncome;
    public void put(double amountToPut) {
        double compareField = getSumma();
        super.put(amountToPut);
        if(compareField!=getSumma())
        {
            lastIncome = LocalDate.now();
        }
    }
    public void take(double amountToTake) {
        LocalDate  timeThroughMonth= lastIncome.plusMonths(1);
        LocalDate futureTime = LocalDate.now();
        boolean compare = futureTime.compareTo(timeThroughMonth)>0;
        if(compare){
            super.take(amountToTake);
       } else {
            System.out.println("Нельзя снять деньги с депозита,прошло меньше месяца с пополнения");
        }
    }

}
