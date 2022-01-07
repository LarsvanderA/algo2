import java.util.LinkedList;
import java.util.*;

public class Main {

//    static final String S = Parser.read();
    static final String S = "VVMMMVMVVVMVMMMVV";
    static int minimum = Integer.MAX_VALUE;


    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add(S);
        algorithm(s, 0);
        System.out.println(minimum);
    }

    public static void algorithm (List<String> strs, int result) {
        // Base case
        if (strs.get(strs.size()-1) == "") {
            if (result < minimum) {
                minimum = result;
            }
        } else {
            // Recursive case

            // Get all possible folds
            List<List<String>> possibleFolds = new LinkedList<>(maxFolds(strs));


            // For all possible folds call this function
            for (List<String> newStr : possibleFolds) {
                if (!(result + 1 >= minimum)){
                    algorithm(newStr, result + 1);
                }
            }
        }
    }

    public static int getIndexOfLargest( int[] a )
    {
        if ( a == null || a.length == 0 ) {
            return -1;
        }

        int largest = 0;
        for ( int i = 1; i < a.length; i++ )
        {
            if ( a[i] > a[largest] ){
                largest = i;
            }
        }
        return largest;
    }

    public static String fold (String str, int amount, int index){
        StringBuilder stringBuilder = new StringBuilder(str);
        for(int i = 0; i <= amount; i++){
            stringBuilder.deleteCharAt(index-amount);
        }
        return stringBuilder.toString();
    }

    public static List<List<String>> maxFolds (List<String> strs) {
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i < strs.get(strs.size()-1).length(); i++) {
            result.add(biggestPartition(strs, i));
        }

        return result;
    }

    public static List<String> biggestPartition(List<String> strs, int startIndex) {
        String str = strs.get(strs.size()-1);
        int minIndex = startIndex - 1;
        int maxIndex = startIndex + 1;
        int result = 0;

        if (minIndex >= 0 && maxIndex < str.length()) {
            if (!(str.charAt(minIndex) == str.charAt(maxIndex))) {
                return biggestPartition(strs, result + 1, minIndex, maxIndex, startIndex);
            }
        }
        strs.add(fold(str, result, startIndex));

        return strs;

    }

    public static List<String> biggestPartition(List<String> strs, int result, int minIndex, int maxIndex, int startIndex) {
        String str = strs.get(strs.size()-1);
        int min = minIndex - 1;
        int max = maxIndex + 1;

        if (min >= 0 && max < str.length()) {
            if (!(str.charAt(min) == str.charAt(max))) {
                return biggestPartition(strs, (result + 1), min, max, startIndex);
            }
        }

        strs.add(fold(str, result, startIndex));

        return strs;
    }


}
