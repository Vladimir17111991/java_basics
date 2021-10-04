public class Main {

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль

    System.out.println(summa(text));
  }
  public static int summa(String text) {
    int rezult = 0;
    char symbol;
    String s="";
for(int i = 0;i<text.length();i++) {
  symbol = text.charAt(i);
       if (Character.isDigit(symbol)) {
      s += symbol;
         if(text.charAt(i+1)==' ')
         {
           rezult +=Integer.parseInt(s);
           s="";
         }
    }
  }
    return rezult;
    }
}