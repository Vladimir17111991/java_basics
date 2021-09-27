package ru.skillbox;

public class Basket {

    private static int count = 0;
    private static int countProduct = 0;
    private static int priceProduct = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        //increasePrice(0);
        items = "Список товаров:";
        this.limit = 1000000;
    }
    public static int getCount() {
        return count;
    }
    public static int getCountProduct() {
        return countProduct;
    }
    public static int getPrice() {
        return priceProduct;
    }

    //подсчет кол-ва продуктов в корзине
    public static void increaseCountProduct(int count) {
        Basket.countProduct = Basket.countProduct + count;
    }
    //подсчет кол-ва корзин
    public static void increaseCount(int count) { Basket.count = Basket.count + 1;}

    //подсчет кол-ва цены товаров в корзине
    public static void increasePrice(int count,int price){
        Basket.priceProduct = Basket.priceProduct + count*price;
    }
    //подсчет средней цены товаров во всех корзинах
    public static double averagePriceProduct()
    {
        return (double) getPrice()/getCountProduct();
    }
    //подсчет средней стоимости корзины
    public static double averagePriceBasket()
    {
        return (double) getPrice()/getCount();
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;

    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        items = items + ", вес - " + weight;
        totalWeight = totalWeight + weight;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        increaseCountProduct(count);
        increasePrice(count,price);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
