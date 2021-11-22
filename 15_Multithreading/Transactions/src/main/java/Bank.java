import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
            getAccounts().get(fromAccountNum).setBlock(true);
            getAccounts().get(toAccountNum).setBlock(true);
            System.err.println("Блокировка счетов: " + fromAccountNum + " и " + toAccountNum);
        }
        if (!getAccounts().get(fromAccountNum).isBlock() && !getAccounts().get(toAccountNum).isBlock()) {
        synchronized (this) {
            if (amount <= getBalance(fromAccountNum)) {
                    System.out.println("Аккаунт - " + accounts.get(fromAccountNum).getAccNumber() +
                            " имеет денег - " + accounts.get(fromAccountNum).getMoney());
                    System.out.println("Аккаунт - " + accounts.get(toAccountNum).getAccNumber() +
                            " имеет денег - " + accounts.get(toAccountNum).getMoney());
                    System.out.println("Отнялось - " + amount);

                    accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                    accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);

                    System.out.println("Аккаунт - " + accounts.get(fromAccountNum).getAccNumber() +
                            " имеет денег - " + accounts.get(fromAccountNum).getMoney());
                    System.out.println("Аккаунт - " + accounts.get(toAccountNum).getAccNumber() +
                            " имеет денег - " + accounts.get(toAccountNum).getMoney()
                            + "\n");
                } else {
                    System.err.println("Количество денег на счете меньше запрашиваемой суммы");
                }
            }
        }
        else {System.err.println("Снятие наличных невозможно, т.к. счета заблокированы");}
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return 0;
    }
}
