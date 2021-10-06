public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
    String flag;
        for(int i = 0;i<strings.length-i;i++)
      {
          flag = strings[i];
          strings[i] =strings[strings.length-i-1];
          strings[strings.length-i-1]=flag;
      }
        return strings;
    }
}
