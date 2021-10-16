import java.util.*;

public class Company  {
    private String nameCompany;
    private final int count;
    private int income;
    ArrayList<Employee> list = new ArrayList<>();
   // ArrayList<Integer> listCopy = new ArrayList<>();

    public Company(String nameCompany, int income, int count) {
        this.nameCompany = nameCompany;
        this.income = income;
        this.count = count;
    }

    public void hire(Employee employee) {
        list.add(employee);


    }

    public void hireAll(int countOperator, int countManager, int countTopManager) {
        for (int i = 0; i < countOperator; i++) {
            hire(new Operator());
        }
        for (int i = 0; i < countManager; i++) {
            hire(new Manager());
        }
        for (int i = 0; i < countTopManager; i++) {
            hire(new TopManager(getIncome()));
        }
    }

    public void fire(Employee employee) {
        list.remove((int) (Math.round(Math.random() * count)));
    }

    public int getIncome() {
        return income;
    }


    public List<Employee> getTopSalaryStaff(int count) {
        if (count >= 0 && count <= getCount()) {
                list.sort(new EmployeeComparator());
            }
        return list;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return null;
    }


    public int getCount() {
        return count;
    }


    public void setIncome(int income) {
        this.income = income;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }
}
