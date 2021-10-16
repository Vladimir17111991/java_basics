public class Operator implements Employee{
    private final int salary = (int)Math.round(Math.random()*10_000 + 20_000);

    public int getSalary() {
        return salary;
    }

    @Override
    public int getMonthSalary() {
        return getSalary();
    }
}
