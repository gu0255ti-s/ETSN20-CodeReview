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

        //Input filename
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        System.out.println("--------------------------");
        System.out.println("Enter a filename (without .txt): ");
        System.out.println("possible file names to choose from: avicii or catData");
        System.out.println("--------------------------");
        String name = sc.nextLine(); // reads string.

        //Input filter pattern
        System.out.println("--------------------------");
        System.out.println("Enter a pattern to filter on: ");
        System.out.println("for avicii try a year between 2012 and 2019, for catData try cat");
        System.out.println("--------------------------");
        String pattern = sc.nextLine(); // reads string.
        System.out.println("--------------------------");
        String fileName = getPath(name+".txt");

        // read file into stream and filter based on filter pattern
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.filter(l -> l.contains(pattern))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("--------------------");
            System.out.println(e);
            System.out.println("--------------------");
            System.out.println("Try avicii or catData");
        }
    }

    public static void main(String args[]) {
        FilterData fd = new FilterData();
        fd.run();
    }

}