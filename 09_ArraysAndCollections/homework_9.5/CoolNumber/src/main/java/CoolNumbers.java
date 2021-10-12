import java.util.*;

public class CoolNumbers {
    static List<String> list = new ArrayList<>();
    static HashSet<String> hashSet = new HashSet<>(generateCoolNumbers());
    static TreeSet<String> treeSet = new TreeSet<>(generateCoolNumbers());

    public static List<String> generateCoolNumbers() {
        list.clear();
        Random random = new Random();
        String allowedLetters = "АВЕКМНОРСТУХ";
        char firstSymbol, secondSymbol, thirdSymbol;
        String autoNumber;
        for (int i = 0; i < 2000000; i++) {
            String formatStringRegion = "";
            String formatStringNumber = "";
            int region = (int) Math.round(Math.random() * 199);
            if (region < 10) {
                formatStringRegion = "00" + region;
            } else if (region < 100) {
                formatStringRegion = "0" + region;
            } else {
                formatStringRegion += region;
            }
            int number = (int) Math.round(Math.random() * 999);
            if (number < 10) {
                formatStringNumber = "00" + number;
            } else if (number < 100) {
                formatStringNumber = "0" + number;
            } else {
                formatStringNumber += number;
            }
            firstSymbol = allowedLetters.charAt(random.nextInt(allowedLetters.length()));
            secondSymbol = allowedLetters.charAt(random.nextInt(allowedLetters.length()));
            thirdSymbol = allowedLetters.charAt(random.nextInt(allowedLetters.length()));
            autoNumber = (firstSymbol) + "" + formatStringNumber + "" + secondSymbol + "" + thirdSymbol + "" + formatStringRegion;
            list.add(autoNumber);
        }
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (number.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int i = Collections.binarySearch(sortedList, number);
        if (i >= 0) {
            return true;
        } else
            return false;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        hashSet.addAll(list);
        if (hashSet.contains(number)) {
            return true;
        } else
            return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        treeSet.addAll(list);
        if (treeSet.contains(number)) {
            return true;
        } else
            return false;
    }

}
