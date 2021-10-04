import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String letter = scanner.nextLine();
    System.out.println(splitTextIntoWords(letter));

  }

  public static String splitTextIntoWords(String text) {
      String regex = "\\s+";
      String regex2 = "[,-;.0-9]";
      String modifyText = text.replaceAll(regex2," ");
      String rezult = "";
      String[] massivStr = modifyText.split(regex);

      for(int i = 0; i < massivStr.length; i++)
      {
          if(i==massivStr.length-1) {
              rezult += massivStr[i];
          }

          else {
              rezult += massivStr[i] + "\n";
          }
      }
      return rezult;

    //TODO реализуйте метод
  }
}