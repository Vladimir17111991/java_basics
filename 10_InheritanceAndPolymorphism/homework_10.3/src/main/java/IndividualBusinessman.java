public class IndividualBusinessman extends Client {
   private double commission;
    public void put(double amountToPut) {

        if (amountToPut < 1000) {
            commission = amountToPut * 0.99;
            super.put(commission);
        } else if (amountToPut >= 1000) {
            commission = amountToPut * 0.995;
            super.put(commission);
        }
    }
    @Override
    public void info() {
        System.out.println("Денег на счете " + getAmount() +
                ". Пополнение денег идет с комиссией 1%,если сумма меньше 1000 рублей" +
                " и 0.5% если сумма больше 1000 рублей." +
                " Итоговая сумма пополнения " + commission);
    }
}
