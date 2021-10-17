public class TopManager implements Employee {
    private int income;

    private final int fixedSalary = (int) Math.round(Math.random() * 25_000 + 40_000);

    public int getFixedSalary() {
        return fixedSalary;
    }

    private final int salary = (int) (getFixedSalary() + (getFixedSalary() * 1.5));

    public int getSalary() {
        return salary;
    }


    public TopManager(int income) {
        this.income = income;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public int getMonthSalary() {
        if (income >= 10_000_000) {
            return getSalary();
        } else return getFixedSalary();
    }
}
