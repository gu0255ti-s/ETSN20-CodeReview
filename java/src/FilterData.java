import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FilterData {

    public FilterData() {
        // constructor
    }

    private String getPath(String fileName) {
        return System.getProperty("user.dir") + "/java/assets/" + fileName;
    }

    private void run() {

        Scanner sc = new Scanner(System.in); // System.in is a standard input stream.
        System.out.print("Enter a filename (without .txt): ");
        String name = sc.nextLine(); // reads string.

        System.out.print("Enter a pattern to filter on: ");
        String pattern = sc.nextLine(); // reads string.

        String fileName = getPath(name+".txt");

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.filter(l -> l.contains(pattern))
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FilterData fd = new FilterData();
        fd.run();
    }

}