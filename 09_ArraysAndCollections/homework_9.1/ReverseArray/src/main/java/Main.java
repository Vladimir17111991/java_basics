import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] masivLine = line.split(",?\\s");
        String[] array=ReverseArray.reverse(masivLine);
            System.out.println(Arrays.toString(array));
       // }

    }
}
