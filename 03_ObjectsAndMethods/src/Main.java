public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40,1,56);
        basket.add("Coffe", 70,4,75);
        basket.print("Milk");
        System.out.println("Общий стоимость продуктов в корзине: " + basket.getTotalPrice() + " рублей");
        System.out.println("Общий вес продуктов в корзине: " + basket.getTotalWeight() + " грамм(-ов)");
        System.out.println("=========================================================");
        Arithmetic arithmetic = new Arithmetic(5,10);
        System.out.println(arithmetic.multiplyOfNumbers());
        System.out.println("=========================================================");
        Printer printer = new Printer();
        printer.append("Стройка века","Акт №17",157);
        printer.append("Разрушение века","Акт №20",48);
        printer.print("Documents");
        System.out.println("Общее число распечатанных страниц: " + printer.getTotalCountPages());

    }
}
