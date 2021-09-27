package ru.skillbox;

public class Main {
    public static void main(String[] args) {
    Basket basket = new Basket();
        basket.add("Milk", 20, 1, 56);
        basket.add("Coffe", 30, 2, 75);
        basket.print("Корзина 1");
       /* System.out.println("Общий стоимость продуктов в корзине: " + basket.getTotalPrice() + " рублей");
        System.out.println("Общий вес продуктов в корзине: " + basket.getTotalWeight() + " грамм(-ов)");
        System.out.println("=========================================================");
        Arithmetic arithmetic = new Arithmetic(5, 10);
        System.out.println(arithmetic.multiplyOfNumbers());
        System.out.println("=========================================================");
        Printer printer = new Printer();
        printer.append("Стройка века", "Акт №17", 157);
        printer.append("Разрушение века", "Акт №20", 48);
        printer.print("Documents");
        System.out.println("Общее число распечатанных страниц: " + printer.getTotalCountPages());
        */
        System.out.println();

    Basket basket2 = new Basket();
        basket2.add("Tea", 5,10,6);
        basket2.add("Loaf", 1,2,2);
        basket2.print("Корзина 2");
        System.out.println();
        System.out.println("Колличество корзин - " + Basket.getCount());
        System.out.println("Колличество предметов в корзинах - " + Basket.getCountProduct() + " шт.");
        System.out.println("Общая сумма продуктов во всех корзинах - " + Basket.getPrice() + " рублей");
        System.out.println("Средняя стоимость товара - " + Basket.averagePriceProduct());
        System.out.println("Средняя стоимость корзины - " + Basket.averagePriceBasket());
}
}
