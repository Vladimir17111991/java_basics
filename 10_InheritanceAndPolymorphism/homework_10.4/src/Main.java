import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
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
            int count = countManager+countOperator+countTopManager;
            Company company = new Company(nameCompany, incomeCompany,count);

                    company.hireAll(countOperator,countManager,countTopManager);
            List<Employee> arrayList =company.getTopSalaryStaff(count);
            for(Employee e:arrayList)
            {
                System.out.println(e.getMonthSalary());
            }
          //      System.out.println(company.getTopSalaryStaff(count));

            if (scanner.nextLine().equals("0"))
            {break;}
        }
    }
}
