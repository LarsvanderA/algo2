import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    public static String read (String path) throws FileNotFoundException{
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();
    }
}
