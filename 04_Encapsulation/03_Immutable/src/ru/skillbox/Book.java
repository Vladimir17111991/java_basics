package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int amountPages;
    private final int numberISBN;

    public Book(String name, String author, int amountPages, int numberISBN) {
        this.name = name;
        this.author = author;
        this.amountPages = amountPages;
        this.numberISBN = numberISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public int getNumberISBN() {
        return numberISBN;
    }
}
