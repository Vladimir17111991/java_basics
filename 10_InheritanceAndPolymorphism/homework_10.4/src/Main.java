import java.util.*;

public class Main {

    static Company company;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Создать компанию ? (Да/Нет)");
            String input = scanner.nextLine();
            if (input.equals("Да")) {
                infoCompany(scanner);
                listForTopSalary(company);
                System.out.println("///////////////");
                listForLowSalary(company);
                System.out.println("///////////////");
                deleteEmployee(scanner, company);
                System.out.println("///////////////");
                listForTopSalary(company);
                System.out.println("///////////////");
                listForLowSalary(company);
            }
            if (input.equals("Нет")) {
                break;
            }
        }
    }

    public static void listForTopSalary(Company company) {
        int countForTopSalary = (int) (Math.ceil((Math.random() * 5) + 10));
        System.out.println("Список из " + countForTopSalary + " зарплат по убыванию");
        List<Employee> arrayList = company.getTopSalaryStaff(countForTopSalary);
        for (Employee e : arrayList) {
            System.out.println(e.getMonthSalary());
        }
    }

    public static void listForLowSalary(Company company) {
        int countForLowSalary = 30;
        System.out.println("Список из " + countForLowSalary + " зарплат по возрастанию");
        List<Employee> arrayList2 = company.getLowestSalaryStaff(countForLowSalary);
        for (Employee e : arrayList2) {
            System.out.println(e.getMonthSalary());
        }
    }

    public static void deleteEmployee(Scanner scanner, Company company) {
        System.out.println("Сколько процентов сотрудников вы хотите уволить?");
        int deletePercent = Integer.parseInt(scanner.nextLine());
        company.fire(deletePercent);
    }

    public static void infoCompany(Scanner scanner){
        System.out.println("Введите имя компании");
        String nameCompany = scanner.nextLine();

        System.out.println("Введите доход компании");
         int incomeCompany = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите число операторов ");
         int countOperator = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите число менеджеров ");
         int countManager = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите число топ-менеджеров ");
        int countTopManager = Integer.parseInt(scanner.nextLine());

        System.out.println("Компания " + nameCompany + " с доходом в " + incomeCompany + " руб."
                + " Сотрудники: " + countOperator + " операторов, "
                + countManager + " менеджеров, "
                + countTopManager + " Топ-менеджеров");
        int count = countManager + countOperator + countTopManager;

        company = new Company(nameCompany, incomeCompany, count);
        company.hireAll(countOperator, countManager, countTopManager);
    }
}
