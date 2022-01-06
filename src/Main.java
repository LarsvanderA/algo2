public class Main {

//    static final String S = Parser.read();
    static final String S = "MMMMVVM";


    public static void main(String[] args) {
        System.out.println(algorithm(S));
    }

    public static int algorithm (String str) {
        String s = str;
        int result = 0;
        while (s != "") {
            int[] maxFolds = maxFolds(s);
            int indexLargest = getIndexOfLargest(maxFolds);
            if (indexLargest == -1) {
                break;
            }
            s = fold2(s, maxFolds[indexLargest], indexLargest);
            result++;
        }

        return result;
    }

    public static int getIndexOfLargest( int[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
        {
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest; // position of the first largest found
    }

    public static String fold (String str, int amount, int index){
        StringBuilder stringBuilder = new StringBuilder(str);
        for(int i = 0; i <= amount; i++){
            stringBuilder.deleteCharAt(index);
        }
        return stringBuilder.toString();
    }

    public static String fold2 (String str, int amount, int index){
        StringBuilder stringBuilder = new StringBuilder(str);
        for(int i = 0; i <= amount; i++){
            stringBuilder.deleteCharAt(index-amount);
        }
        return stringBuilder.toString();
    }

    public static int[] maxFolds (String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = biggestPartition(str, i);
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
