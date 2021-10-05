import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
       //      String s = "905-1234567";
    Scanner scanner = new Scanner(System.in);
        while (true) {
          String input = scanner.nextLine();
          if (input.equals("0")) {
            break;
          }
            System.out.println(phoneNumber(input));
        //TODO:напишите ваш код тут, результат вывести в консоль.
      }
    }

    public static String phoneNumber(String text) {
        String s = "";
        String regex = "[^0-9]";
        String regex2 = "[7,8][0-9]{10,11}";
        Pattern pattern = Pattern.compile(regex2);
        String modifyText = text.replaceAll(regex, "");
        char a = modifyText.charAt(0);
        if(modifyText.length() == 11) {
            modifyText = modifyText.replace(a, '7');
        }
       if(modifyText.length() == 10) {
           modifyText = (new StringBuilder(modifyText).insert(0,"7")).toString();
           a = modifyText.charAt(0);
        }
       Matcher matcher = pattern.matcher(modifyText);
       while (matcher.find()) {
           int start = matcher.start();
           int end = matcher.end();
           s = modifyText.substring(start, end);
       }
       if(modifyText.length() < 10 ||
               modifyText.length() > 11 ||
               (modifyText.length() == 11 && a != '7' && a != '8')
       ) {
           s = "Неверный формат номера";
       }
       return s;
    }
}
