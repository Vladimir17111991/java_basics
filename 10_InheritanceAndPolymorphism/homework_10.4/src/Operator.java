import java.util.Random;

public class Operator implements Employee,Comparable<Employee>{
    @Override
    public int getMonthSalary() {
        return (int)Math.round(Math.random()*10_000 + 20_000);
    }

    @Override
    public int compareTo(Employee o) {
        return this.getMonthSalary()-o.getMonthSalary();
    }
}
