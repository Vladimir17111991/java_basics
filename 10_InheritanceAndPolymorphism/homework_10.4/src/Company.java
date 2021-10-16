import java.util.*;

public class Company {
    private String nameCompany;
    private final int count;
    private int income;
    ArrayList<Employee> list = new ArrayList<>();
    ArrayList<Employee> list2 = new ArrayList<>();

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

    public void fire(int count) {
        int i = 0;
        double percent = (double) count / 100;
        int count2 = (int) (getCount() - getCount() * percent);
        while (i < count2) {
            list.remove((int) Math.ceil(Math.random() * (list.size() - 1)));
            i++;
        }
    }

    public int getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count >= 0 && count <= getCount()) {
            list2.clear();
            list.sort(new EmployeeComparator());
            for (int i = 0; i < count; i++) {
                list2.add(list.get(i));
            }
        }
        return list2;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count >= 0 && count <= getCount()) {
            list2.clear();
            list.sort(new EmployeeComparator().reversed());
            for (int i = 0; i < count; i++) {
                list2.add(list.get(i));
            }
        }
        return list2;
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
