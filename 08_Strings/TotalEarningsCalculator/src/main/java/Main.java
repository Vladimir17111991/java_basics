public class Main {

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    System.out.println(summa(text));
  }
  public static int summa(String text) {
    int rezult;
    String text1 = "заработал ";
    String text2 = " - ";

    int index1 = text.indexOf(text1) + text1.length();
    int index2 = text.indexOf(" рублей,");

    int index3= text.indexOf(text2) + text2.length();
    int index4= text.indexOf(" рубля,");

    int index5= text.lastIndexOf(text2) + text2.length();
    int index6= text.lastIndexOf(" рублей");

    String firstPrice = text.substring(index1,index2).trim();
    String secondPrice = text.substring(index3,index4).trim();
    String thirdPrice = text.substring(index5,index6).trim();
    rezult = Integer.parseInt(firstPrice) + Integer.parseInt(secondPrice) + Integer.parseInt(thirdPrice);

    return rezult;
    }
}