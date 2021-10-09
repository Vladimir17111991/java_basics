import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */
   public static EmailList emailList = new EmailList();

    public static void main(String[] args) {
        String regexCommand = "[A-Z]{3,4}";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexCommand);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String firstWord = input.substring(start, end).trim();
                if (firstWord.equals("ADD")) {
                    input = input.replaceFirst(firstWord, "").trim();
                    emailList.add(input);
                }
                if (firstWord.equals("LIST")) {
                    emailList.getSortedEmails();
                }
            } else {
                System.out.println("Неверная команда");
            }

            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
        }
    }
}
