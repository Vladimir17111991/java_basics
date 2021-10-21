import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String regexForPhone = "[+\\d]+";
        String regexForMail = "[a-z]+\\d*?@[a-z]+[.][a-z]+";
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Correct format: name surname email phone");
        }
        if (checkingArrayElements(components, 3, regexForPhone)) {
            throw new NumberFormatException("Example correct format phone: +79123456789");
        }
        if (checkingArrayElements(components, 2, regexForMail)) {
            throw new IllegalArgumentException("Example correct format e-mail: examples@gmail.com");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public boolean checkingArrayElements(String[] array, int indexArray, String regularExpression) {
        String result = "";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(array[indexArray]);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            result = array[indexArray].substring(start, end).trim();
        }
        return result.compareTo(array[indexArray]) != 0;
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}