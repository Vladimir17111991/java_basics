import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        // TODO: написать консольное приложение для работы со списком дел todoList
        String firstWord = "";
        String secondWords;
        String regex = "[A-Z]+";
        String regex2 = "[A-Z]+\\s+[0-9]+\\s?";
        int numberEqualToIndex;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                firstWord = input.substring(start, end);
            }
            //Редактирование элемента
            if (firstWord.equals("EDIT")) {
                pattern = Pattern.compile(regex2);
                matcher = pattern.matcher(input);
                if (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    secondWords = input.substring(start, end).trim();
                    numberEqualToIndex = Integer.parseInt(secondWords.replace(firstWord, "").trim());
                    input = input.replaceFirst(secondWords, "").trim();
                    todoList.edit(input, numberEqualToIndex);
                } else {
                    System.out.println("Неккоректно введена команда. " +
                            "Необходимо ввести EDIT <число изменяемого элемента><имя нового элемента>");
                }
            }
            //Добавление элемента
            if (firstWord.equals("ADD")) {
                pattern = Pattern.compile(regex2);
                matcher = pattern.matcher(input);
                if (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    secondWords = input.substring(start, end).trim();
                    numberEqualToIndex = Integer.parseInt(secondWords.replace(firstWord, "").trim());
                    input = input.replaceFirst(secondWords, "").trim();
                    todoList.add(numberEqualToIndex, input);
                } else {
                    input = input.replace(firstWord, "").trim();
                    todoList.add(input);
                }
            }
            //Удаление элемента
            if (firstWord.equals("DELETE")) {
                pattern = Pattern.compile(regex2);
                matcher = pattern.matcher(input);
                if (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    secondWords = input.substring(start, end).trim();
                    numberEqualToIndex = Integer.parseInt(secondWords.replace(firstWord, "").trim());
                    todoList.delete(numberEqualToIndex);
                } else {
                    System.out.println("Неккоректно введена команда. Необходимо ввести DELETE <число>");
                }
            }
            //Просмотр списка элементов
            if (firstWord.equals("LIST")) {
                todoList.getTodos();
            }
            if (input.equals("0")) {
                break;
            }
        }
    }
}

