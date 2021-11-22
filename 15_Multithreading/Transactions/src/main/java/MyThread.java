import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private final Bank bank;

    public MyThread(Bank bank) {
        this.bank = bank;
    }

    private static AtomicInteger countThreads = new AtomicInteger();

    public static void incrementValue() {
        countThreads.incrementAndGet();
    }

    @Override
    public void run() {
        String numberFrom = String.valueOf(Math.round(Math.random() * 10000));
        String numberTo = String.valueOf(Math.round(Math.random() * 10000));
        long money = Math.round(Math.random() * 55000);
        try {
            System.out.println("Поток №" + countThreads);
            bank.transfer(numberFrom, numberTo, money);

            incrementValue();
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
