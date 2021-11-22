import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentMap<String, Account> accountMap = new ConcurrentHashMap<>();
        Vector<MyThread> threads = new Vector<>();
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            Bank bank = new Bank();
            for (int j = 0; j < 10000; j++) {
                Account account = new Account();
                account.setAccNumber(String.valueOf(j));
                account.setMoney(Math.round(Math.random() * 50_000));
               accountMap.putIfAbsent(String.valueOf(j), account);
               // accountMap.put(String.valueOf(j), account);
            }
            bank.setAccounts(accountMap);
            threads.add(new MyThread(bank));
        }
        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}



