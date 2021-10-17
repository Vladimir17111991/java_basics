public class Manager implements Employee {
    private final int fixedSalary = (int) Math.round(Math.random() * 15_000 + 30_000);

    public int getFixedSalary() {
        return fixedSalary;
    }

    private final int salary = (int) (getFixedSalary() +
            ((Math.ceil(((Math.random() * 140_000 - 115_000) + 115_000) *
                    Math.pow(10, 1) / Math.pow(10, 1))) * 0.05));

    public int getSalary() {
        return salary;
    }

    @Override
    public int getMonthSalary() {
        return getSalary();
    }


}
