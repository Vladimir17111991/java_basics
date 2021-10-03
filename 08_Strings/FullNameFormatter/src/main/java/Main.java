import java.util.Scanner;

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
    String surname = "", name = "", patronymic = "", text = "";
    int spaceCount = 0;
    input.trim();
    char symbol2 = ' ';
    for (int i = 0; i < input.length(); i++) {
       char symbol = input.charAt(i);
        if((!Character.UnicodeBlock.of(symbol).equals(Character.UnicodeBlock.CYRILLIC))&&symbol!=' '&&symbol!='-') {
            break;
        }
        else
        {
            int index = input.indexOf(symbol) + 1;
            int index2 = input.lastIndexOf(symbol2) + 1;
            if (symbol == ' ') {
                if (spaceCount == 0) {
                    surname = input.substring(0, index).trim();
                } else if (spaceCount == 1) {
                    name = input.substring(index, index2).trim();
                    patronymic = input.substring(index2).trim();
                }
                spaceCount++;
            }
        }
    }
    if (spaceCount != 2) {
            System.out.println("Введенная строка не является ФИО");
        } else {
            text = "Фамилия: " + surname + "\n" +
                    "Имя: " + name + "\n" +
                    "Отчество: " + patronymic;
        }
    return text;
  }
}