public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        //for(char i ='А'; i<='я';i++)
        for(int i = 0; i < 65536;i++)
        {
            char a = (char) i;
            if(a >= 'А' && a <= 'я' || a == 'Ё' || a == 'ё')
             {
                 System.out.println(a + " - " +  i);
             }
        }
    }
}
