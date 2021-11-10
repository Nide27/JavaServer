package paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paths {
    public static void main(String[] args) {
        Path path = Path.of("text2.txt");
        try {
            Stream<String> linesStream = Files.lines(path)
                                              .filter((line) -> line.equals("even cooler"));
            List<String> filteredLines = linesStream.collect(Collectors.toList());

            System.out.println(filteredLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
