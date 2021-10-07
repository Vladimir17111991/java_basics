import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        String s = "";
        int flag = 0;
        todoList.add(0, "learn java");
        todoList.add(1, "learn java");
        todoList.add(2, "learn java");
        todoList.add(5, "new todo");
        int rezult = 0;
        String ss = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String regex = "[A-Z]+";
            String regex2 = "\\s+[0-9]+\\s+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                s = input.substring(start, end).trim();
            }
            if (s.equals("ADD")) {
                String[] inpAr = input.split(regex);
                if (inpAr.length != 0) {
                    Pattern pattern1 = Pattern.compile(regex2);
                    Matcher matcher1 = pattern1.matcher(input);
                    while (matcher1.find()) {
                        int start = matcher1.start();
                        int end = matcher1.end();
                        ss = input.substring(start, end).trim();
                        rezult = Integer.parseInt(ss);
                        flag = 1;
                    }
                    if (Character.isDigit(inpAr[1].charAt(1)) && flag == 1) {
                        inpAr[1] = inpAr[1].replaceFirst(ss, "").trim();
                        todoList.add(rezult, inpAr[1]);
                        flag = 0;
                    } else {
                        todoList.add(inpAr[1]);
                    }
                } else {
                    System.out.println("Неккоректно введена команда. Необходимо ввести ADD <имя> или ADD <число> <имя>");
                }
            }
            if (s.equals("LIST")) {
                todoList.getTodos();
            }
            if (s.equals("DELETE")) {
                String regex3 = "\\s+";
                String[] inpAr2 = input.split(regex3);
                if (inpAr2.length != 1) {
                    todoList.delete(Integer.parseInt(inpAr2[1]));
                } else {
                    System.out.println("Неккоректно введена команда. Необходимо ввести DELETE <число>");
                }
            }
            if (s.equals("EDIT")) {
                String[] inpAr3 = input.split(regex);
                if (inpAr3.length != 0 && inpAr3.length != 1) {
                    Pattern pattern1 = Pattern.compile(regex2);
                    Matcher matcher1 = pattern1.matcher(input);
                    while (matcher1.find()) {
                        int start = matcher1.start();
                        int end = matcher1.end();
                        ss = input.substring(start, end).trim();
                        rezult = Integer.parseInt(ss);
                        flag = 1;
                    }
                    if (Character.isDigit(inpAr3[1].charAt(1)) && flag == 1) {
                        inpAr3[1] = inpAr3[1].replaceFirst(ss, "").trim();
                        todoList.edit(inpAr3[1], rezult);
                        flag = 0;
                    }
                } else {
                    System.out.println("Неккоректно введена команда. " +
                            "Необходимо ввести EDIT <число изменяемого элемента><имя нового элемента>");
                }
            }
            if (input.equals("0")) {
                break;
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}

