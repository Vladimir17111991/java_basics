import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private long money;
    private String accNumber;
    Bank bank = new Bank();
    private boolean block = false;

    // private final Lock R = new ReentrantLock();
    public void setBlock(boolean block) {
        this.block = block;
    }

    public boolean isBlock() {
        return block;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        if (!block) {
            //   R.unlock();
            //   synchronized (isBlock() ? this:money) {
            this.money = money;
        }
        //    }
        //   else
        //   R.lock();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        if (!block) {
            //  R.unlock();
            //  synchronized (isBlock() ? this : accNumber) {
            this.accNumber = accNumber;
        }
    }
    // else
    //      R.lock();
    //   }
}
