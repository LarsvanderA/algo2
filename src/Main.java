import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    //    static final String S = Parser.read();
    static final String S = "MVMMMVVMMVMMVVVMVVM";


    public static void main(String[] args) {
        System.out.println(algorithm(S));
    }

    public static int algorithm(String str) {

        PriorityQueue<Fold> PQueue = new PriorityQueue();
        int min = Integer.MAX_VALUE;

        Fold[] maxFolds = maxFolds(str, 0);
        Arrays.asList(maxFolds).stream().filter(n -> (n.getCurrentFolds() + 1) < min).forEach(n -> {
            if (n.getRemaining() != "") {
                PQueue.add(n);
            } else {
                min = Math.min(0, n.getCurrentFolds());
            }
        });

        while (!PQueue.isEmpty()) {
            Fold currentFold = PQueue.poll();
            maxFolds = maxFolds(currentFold.getRemaining(), currentFold.getCurrentFolds());
            Arrays.asList(maxFolds).stream().filter(n -> (n.getCurrentFolds() + 1) < min).forEach(n -> PQueue.add(n));

            int indexLargest = getIndexOfLargest(maxFolds);
            if (indexLargest == -1) {
                break;
            }
        }

        return min;
    }

    public static int getIndexOfLargest(Fold[] array) {
        if (array == null || array.length == 0) return -1; // null or empty

        int largest = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].getFoldSize() > array[largest].getFoldSize()) largest = i;
        }
        return largest; // position of the first largest found
    }

    public static String fold(String str, int amount, int index) {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i <= amount; i++) {
            stringBuilder.deleteCharAt(index);
        }
        return stringBuilder.toString();
    }


    public static Fold[] maxFolds(String str, int folds) {
        Fold[] result = new Fold[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int amount = biggestPartition(str, i);
            Fold f = new Fold(folds+1, fold(str, amount, i), amount);
            result[i] = f;
        }

        return result;
    }

    public static int biggestPartition(String str, int startIndex) {
        int minIndex = startIndex - 1;
        int maxIndex = startIndex + 1;

        if (minIndex >= 0 && maxIndex < str.length()) {
            if (!(str.charAt(minIndex) == str.charAt(maxIndex))) {
                return biggestPartition(str, 1, minIndex, maxIndex);
            }
        }
        return 0;

    }

    public static int biggestPartition(String str, int result, int minIndex, int maxIndex) {
        int min = minIndex - 1;
        int max = maxIndex + 1;

        if (min >= 0 && max < str.length()) {
            if (!(str.charAt(min) == str.charAt(max))) {
                return biggestPartition(str, (result + 1), min, max);
            }
        }
        return result;
    }


}
