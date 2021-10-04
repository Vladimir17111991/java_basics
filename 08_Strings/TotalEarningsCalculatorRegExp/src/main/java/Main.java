import net.sf.saxon.functions.Matches;

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

      System.out.println(calculateSalarySum(input));
    }
  }
  public static int calculateSalarySum(String text){
String regex="[0-9]+";
String te = "";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    int summa = 0;
    while (matcher.find())
    {
      int start = matcher.start();
      int end = matcher.end();
      te =text.substring(start,end);
      summa += Integer.parseInt(te);
    }
    //TODO: реализуйте метод
    return summa;
  }

}