import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;

public class Main {

  public static void main(String[] args) {
int day = 23;
int month = 5;
int year = 1995;
LocalDate birthday = LocalDate.of(year,month,day);
      System.out.println(getPeriodFromBirthday(birthday));
  }

  private static String getPeriodFromBirthday(LocalDate birthday) {
LocalDate now = LocalDate.now();
      String text;
      Period period = Period.between(birthday,now);
      text = period.getYears() + " years, " + period.getMonths() + " month, " +period.getDays() + " days, ";
      return text ;
  }
}
