import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
       for (Employee employee:staff) {
           System.out.println(employee + "\t");
       }

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
//        Collections.sort(staff,(employee1, employee2)->
//        {
//            int varComparison = employee1.getSalary().compareTo(employee2.getSalary());
//            if(varComparison == 0)
//                varComparison = employee1.getName().compareTo(employee2.getName());
//            return varComparison;
//        });
       Collections.sort(staff, Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName));
    }
}