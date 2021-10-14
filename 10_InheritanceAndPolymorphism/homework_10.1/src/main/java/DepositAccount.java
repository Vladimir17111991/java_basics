import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    LocalDate lastIncome;

    public boolean put(double amountToPut) {
        double compareField = getSumma();
        super.put(amountToPut);
        if (compareField != getSumma()) {
            lastIncome = LocalDate.now();
            return true;
        }
        return false;
    }

    public boolean take(double amountToTake) {
        LocalDate timeThroughMonth = lastIncome.plusMonths(1);
        LocalDate futureTime = LocalDate.now();
        boolean compare = futureTime.compareTo(timeThroughMonth) > 0;
        if (compare) {
            super.take(amountToTake);
            return true;
        } else {
            System.out.println("Нельзя снять деньги с депозита,прошло меньше месяца с пополнения");
            return false;
        }
    }

}
