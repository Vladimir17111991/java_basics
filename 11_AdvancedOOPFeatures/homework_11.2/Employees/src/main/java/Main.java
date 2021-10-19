import net.sf.saxon.functions.ConstantFunction;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final String STAFF_TXT = "staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
//Calendar calendar = Calendar.getInstance();
        return staff.stream().filter(employeeYearWork -> employeeYearWork.getWorkStart().getYear() + 1900 >= year)
                .collect(Collectors.toList()).stream().max(Comparator.comparing(Employee::getSalary)).get();


    }

}