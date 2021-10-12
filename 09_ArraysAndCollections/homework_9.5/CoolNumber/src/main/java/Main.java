import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

public static long time1,time2,time3,time4;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();

            //Поиск перебором
            findBruteForce(input);

            //Бинарный поиск
            Collections.sort(CoolNumbers.generateCoolNumbers());
            findBinary(input);

            //Поиск в HashSet
            findHashSet(input);

            //Поиск в TreeSet
            findTreeSet(input);
            minMax(time1, time2, time3, time4);
            if (input.equals("0")) {
                break;
            }
        }
    }
    public static void findBruteForce(String input) {
        String text;
        long start = System.nanoTime();
        boolean findOrNotFind = CoolNumbers.bruteForceSearchInList(CoolNumbers.generateCoolNumbers(), input);
        long end = System.nanoTime();
        if (findOrNotFind) {
            text = " найден ";
        } else {
            text = " не найден ";
        }
        time1 = (end - start);
        System.out.println("Поиск перебором: номер" + text + ",поиск занял " + time1 + " нс");
    }
    public static void findBinary(String input) {
        String text;
        long start = System.nanoTime();
        boolean findOrNotFind = CoolNumbers.binarySearchInList(CoolNumbers.generateCoolNumbers(), input);
        long end = System.nanoTime();
        if (findOrNotFind) {
            text = " найден ";
        } else {
            text = " не найден ";
        }
        time2 = (end - start);
        System.out.println("Бинарный поиск: номер" + text + ",поиск занял " + time2 + " нс");
    }
    public static void findHashSet(String input){
        String text;
        long start = System.nanoTime();
        boolean findOrNotFind = CoolNumbers.searchInHashSet(CoolNumbers.hashSet, input);
        long end = System.nanoTime();
        if (findOrNotFind) {
            text = " найден ";
        } else {
            text = " не найден ";
        }
        time3 = (end - start);
        System.out.println("Поиск в HashSet: номер" + text + ",поиск занял " + time3 + " нс");
    }
    public static void findTreeSet(String input){
        String text;
        long start = System.nanoTime();
        boolean findOrNotFind = CoolNumbers.searchInTreeSet(CoolNumbers.treeSet, input);
        long end = System.nanoTime();
        if (findOrNotFind) {
            text = " найден ";
        } else {
            text = " не найден ";
        }
        time4 = (end - start);
        System.out.println("Поиск в TreeSet: номер" + text + ",поиск занял " + time4 + " нс");
    }
    public static void minMax(long time1, long time2, long time3, long time4) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(time1);
        arrayList.add(time2);
        arrayList.add(time3);
        arrayList.add(time4);

        Collections.sort(arrayList);
        long min = arrayList.get(0);
        long max = arrayList.get(arrayList.size() - 1);
        if (max == time1) {
            System.out.println("Максимальный поиск перебором");
        } else if (max == time2) {
            System.out.println("Максимальный поиск бинарный");
        } else if (max == time3) {
            System.out.println("Максимальный поиск по HashSet");
        } else if (max == time4) {
            System.out.println("Максимальный поиск по TreeSet");
        }
        if (min == time1) {
            System.out.println("Минимальный поиск перебором");
        } else if (min == time2) {
            System.out.println("Минимальный поиск бинарный");
        } else if (min == time3) {
            System.out.println("Минимальный поиск по HashSet");
        } else if (min == time4) {
            System.out.println("Минимальный поиск по TreeSet");
        }

    }
}
