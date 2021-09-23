public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40,1,56);
        basket.add("Coffe", 70,4,75);
        basket.print("Milk");
        System.out.println("Общий стоимость продуктов в корзине: " + basket.getTotalPrice() + " рублей");
        System.out.println("Общий вес продуктов в корзине: " + basket.getTotalWeight() + " грамм(-ов)");
    }
}
