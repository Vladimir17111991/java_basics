import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    Set<String> treeSet = new TreeSet<>();
    List<String> list = new ArrayList<>();
    String regexMail = "[a-z]+\\d*?@[a-z]+[.][a-z]+";

    public void add(String email) {
        // TODO: валидный формат email добавляется
        Pattern pattern = Pattern.compile(regexMail);
        Matcher matcher = pattern.matcher(email.trim());
        if (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            email = email.toLowerCase(Locale.ROOT).substring(start, end).trim();
            treeSet.add(email);
            System.out.println("Добавлен email: " + email);
        } else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        list.addAll(treeSet);
        for (String s : list) {
            System.out.println(s);
        }
        return list;
    }

}
