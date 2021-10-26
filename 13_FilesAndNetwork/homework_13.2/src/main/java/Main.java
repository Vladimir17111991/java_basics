import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к папке,с которой хотите скопировать");
        String line = scanner.nextLine();
       // String s1 = "C:\\mmm\\";
        System.out.println("Введите путь к папке,в которую хотите скопировать");
        String line2 = scanner.nextLine();
       // String s2 = "C:\\mmm2\\";
        FileUtils.copyFolder(line, line2);
        //FileUtils.copyFolder(s1, s2);
    }
}
