public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] massiv= new char[size][size];

        for(int i =0; i<massiv.length;i++) {
            for (int j=0;j<massiv[i].length;j++)
            {
                massiv[i][j]=' ';
                if(i==j||j==massiv[i].length-1-i)
                {
                    massiv[i][j]=symbol;
                    massiv[i][massiv[i].length-1-i]=symbol;
                }
            }
        }
        return massiv;
    }
}
