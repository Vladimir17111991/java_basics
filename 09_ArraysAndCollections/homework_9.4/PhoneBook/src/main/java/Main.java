import java.util.Scanner;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();

    public static void checkSintaksis(String input, String regex) {
        if (!input.matches(regex)) {
            System.out.println("Неверный формат ввода");
        }
    }

    public static void addContactByName(String name, String regexForPhone) {

        if (!phoneBook.map.containsKey(name)) {
            System.out.println("Такого имени в телефонной книге нет.");
            System.out.println("Введите номер телефона для абонента " + name + ": ");
            Scanner scanner = new Scanner(System.in);
            String phone = scanner.nextLine();
            if (phone.matches(regexForPhone)) {
                if (!phoneBook.map.containsValue(phone)) {
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт сохранен");
                }
            } else checkSintaksis(phone, regexForPhone);
        }
    }
    public static void addContactByPhone(String phone,String regexForName) {
        Scanner scanner = new Scanner(System.in);
        if (!phoneBook.map.containsValue(phone)) {
            System.out.println("Такого номера в телефонной книге нет.");
            System.out.println("Введите имя абонента для номера " + phone + ": ");
            String name = scanner.nextLine();
            if (name.matches(regexForName)) {
                if (!phoneBook.map.containsKey(name)) {
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт сохранен");
                } else {
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт изменен");
                }
            } else checkSintaksis(name, regexForName);
        } else {
            System.out.println("Такой номер в телефонной книге есть." +
                    " К какому имени вы хотите привязать данный телефон?");
            String name = scanner.nextLine();
            if (name.matches(regexForName)) {
                if (!phoneBook.map.containsKey(name)) {
                    phoneBook.addContact(phone, name);
                    System.out.println("Имя изменено");
                }
            } else checkSintaksis(name, regexForName);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexForName = "[А-Я][а-я]+";
        String regexForPhone = "[7]\\d+";
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.matches(regexForName)) {
                addContactByName(input, regexForPhone);
            }
            if (input.matches(regexForPhone)) {
                addContactByPhone(input,regexForName);
            }
            if (input.equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
            }
            if (input.equals("0")) {
                break;
            }
        }
    }
}
