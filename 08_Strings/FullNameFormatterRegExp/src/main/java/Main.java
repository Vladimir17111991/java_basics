import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
    while (true) {
     String input = scanner.nextLine();
     if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      System.out.println(fio(input));
    }
  }
  public static String fio(String input) {
    String surname = "", text = "", name = "", patronymic = "";
    int count =0;
    String regex = "[а-яА-Я]+[-[а-яА-Я]?]+";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      count++;
      if (count == 1) {
        surname = input.substring(start, end);
      } else if (count == 2) {
        name = input.substring(start, end);
      } else if (count == 3) {
        patronymic = input.substring(start, end);
      }
    }
    if(count!=3) {
      System.out.println("Введенная строка не является ФИО");
    }
    else {
      text = "Фамилия: " + surname + "\n" +
              "Имя: " + name + "\n" +
              "Отчество: " + patronymic;
    }
    return text;
  }
}


