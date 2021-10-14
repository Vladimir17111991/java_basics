public class LegalPerson extends Client {
   private double commission;
    public void take(double amountToTake) {
    commission = amountToTake * 1.01;
        super.take(commission);
    }
    @Override
    public void info() {
        System.out.println("Денег на счете " + getAmount() +
                ". Снятие денег идет с комиссией 1% и итоговая сумма снятия будет" + commission);
    }
}
