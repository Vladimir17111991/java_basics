import java.util.Arrays;
import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override

    public int compare(Employee o1, Employee o2) {

        int a = o1.getMonthSalary();
        int b = o2.getMonthSalary();
        if (a < b) {
            return 1;
        } else if (a > b) {
            return -1;
        } else
            return 0;
    }
}
