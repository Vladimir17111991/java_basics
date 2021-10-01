import java.util.Scanner;

public class Main {

    public final static int MAX_BOXES_IN_CONTAINER = 27;
    public final static int MAX_CONTAINER_IN_TRUCK = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int box = Integer.parseInt(boxes);
        int countContainer =0;
        int countTruck =0;

    for (int i = 0; i < box; i++) {
        if (i % MAX_BOXES_IN_CONTAINER == 0) {
            if (countContainer % MAX_CONTAINER_IN_TRUCK == 0) {
                countTruck++;
                System.out.println("Грузовик: " + countTruck);
            }
            countContainer++;
            System.out.println("\tКонтейнер: " + countContainer);
        }
        System.out.println("\t\tЯщик: " + (i+1));
    }
    System.out.println("Необходимо:");
    System.out.println("грузовиков - " + countTruck + " шт.");
    System.out.println("контейнеров - " + countContainer + " шт.");
    }
}
        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */



