import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

          int day = 31;
          int month = 12;
          int year = 1990;

        System.out.println(collectBirthdays(year, month, day));
    }
    public static String collectBirthdays(int year, int month, int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        String text = "";
        int g = 0;
            while(today.compareTo(birthday)>=0)  {
                birthday=birthday.plusYears(g);
                if(birthday.isBefore(today)||(birthday.isEqual(today)))
                {
                text =text+ ((g) + " - " + formatter.format(birthday) + System.lineSeparator());
                g++;
                }
            }
        return text;
    }
    //TODO реализуйте метод для построения строки в следующем виде
    //0 - 31.12.1990 - Mon
    //1 - 31.12.1991 - Tue
}