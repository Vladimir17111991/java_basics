import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки: ");
        String line = scanner.nextLine();
        long sum = FileUtils.calculateFolderSize(line);
        System.out.println("Общий размер файлов: ");
        System.out.println(sum + " байт \n"
                + sum / (int)Math.round(Math.pow(1024,1)) + " Кб \n"
                + String.format("%.2f",(double) sum / Math.round(Math.pow(1024,2))) + " Мб \n"
                + String.format("%.2f",(double) sum / Math.round(Math.pow(1024,3))) + " Гб");
    }
}
