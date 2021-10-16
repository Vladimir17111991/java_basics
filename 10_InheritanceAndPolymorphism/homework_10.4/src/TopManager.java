import java.util.Random;

public class TopManager implements Employee{
    private int income;
    private int fixedSalary;
public TopManager(int income)
{
    this.income =income;
}

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    @Override
    public int getMonthSalary() {
        fixedSalary = (int)Math.round(Math.random()*25_000 + 40_000);
        if(income>=10_000_000) {
            return (int)(fixedSalary + (fixedSalary * 1.5));
        }
        else return fixedSalary;
    }
}
