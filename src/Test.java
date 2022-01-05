import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Fold test1 = new Fold(5, "MMVVMVV", 2);
        Fold test2 = new Fold(6, "MMVVVMVMVVMVVVV", 2);
        Fold test3 = new Fold(4, "MVVMVMVVMVMVMVVVVV", 2);
        Fold test4 = new Fold(5, "MMVVMVV", 1);
        Fold test5 = new Fold(5, "MMVVMMV", 3);

        List<Fold> folds = new ArrayList<>();

        folds.add(test1);
        folds.add(test2);
        folds.add(test3);
        folds.add(test4);
        folds.add(test5);

        List<Fold> sortedFolds = folds.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedFolds);

    }
}
