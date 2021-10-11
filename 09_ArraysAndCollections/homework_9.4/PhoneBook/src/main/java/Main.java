import java.util.Scanner;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();
    public static void checkSintaksis(String input,String regex)
    {
        if(!input.matches(regex))
        {
            System.out.println("Неверный формат ввода");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "[А-Я][а-я]+";
        String regex2 = "[7]\\d+";
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                if (!phoneBook.map.containsKey(input)) {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента " + input + ": ");
                    String input2 = scanner.nextLine();
                    if (input2.matches(regex2)) {
                        if (!phoneBook.map.containsValue(input2)) {
                            phoneBook.addContact(input2, input);
                            System.out.println("Контакт сохранен");
                        }
                    }
                    else checkSintaksis(input2,regex2);
                }
            }
            if (input.matches(regex2)) {
                if (!phoneBook.map.containsValue(input)) {
                    System.out.println("Такого номера в телефонной книге нет.");
                    System.out.println("Введите имя абонента для номера " + input + ": ");
                     String input2 = scanner.nextLine();
                    if (input2.matches(regex)) {
                        if (!phoneBook.map.containsKey(input2)) {
                            phoneBook.addContact(input,input2);
                            System.out.println("Контакт сохранен");
                        }
                        else
                        { phoneBook.addContact(input,input2);
                            System.out.println("Контакт изменен");
                        }
                    }
                    else checkSintaksis(input2,regex);
                }
                else {System.out.println("Такой номер в телефонной книге есть." +
                        " К какому имени вы хотите привязать данный телефон?");
                    String input2 = scanner.nextLine();
                    if (input2.matches(regex)) {
                        if(!phoneBook.map.containsKey(input2))
                        phoneBook.addContact(input,input2);
                        System.out.println("Имя изменено");
                        }
                    else checkSintaksis(input2,regex);
                    }
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
