package filereaderwriter;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("text2.txt");
            FileReader fileReader = new FileReader("text2.txt");

            fileWriter.write("this is a cool text");
            fileWriter.write("\nthis is another cool text");
            fileWriter.write("\neven cooler");
            fileWriter.close();

            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.println(i);
                System.out.println((char)i);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
