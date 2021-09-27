package ru.skillbox;

public class Printer {
    private static int totalCountPages = 0;
    private String queue = "";
    private int countPagesOnPrint;

    public void append(String textDoc) {
        append(textDoc, "");
    }

    public void append(String textDoc, String nameDoc) {
        append(textDoc, nameDoc, 1);
    }

    public void append(String textDoc, String nameDoc, int countList) {
        countPagesOnPrint = 0;
        countPagesOnPrint = countPagesOnPrint + countList;
        Printer.totalCountPages = Printer.totalCountPages + countPagesOnPrint;
        queue = queue + "\n" +
                "Имя документа: " + nameDoc + "\n" +
                "Текст документа: " + textDoc + "\n" +
                "Колличество страниц: " + countList + "\n" +
                "Страниц в очереди на печать: " + getPendingPagesCount() + "\n" +
                "Идет печать..." + "\n";

    }

    public int getTotalCountPages() {
        return totalCountPages;
    }

    public int getPendingPagesCount() {
        return countPagesOnPrint;
    }

    public void clear() {
        queue = "";
    }

    public void print(String title) {
        System.out.print(title);
        if (queue.isEmpty()) {
            System.out.println("Очередь документов на печать отсутствует.");
        } else {
            System.out.println(queue);
            clear();
        }
    }
}
