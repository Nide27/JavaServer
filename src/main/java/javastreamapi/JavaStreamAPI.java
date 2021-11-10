package javastreamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamAPI {
    public static List<Person> showCaseJavaStreamApi() {
        List<Person> persons = new ArrayList();
        persons.add(new Person(18));
        persons.add(new Person(10));
        persons.add(new Person(29));

        List<Person> adults = persons                           // source: persons
                .stream()                                       // create
                .filter((person -> person.getAge() >= 18))      // intermediate
                .collect(Collectors.toList());                  // terminal
                                                                // target: adults
        return adults;
    }

    public static void main(String[] args) {
        List<Person> adults = showCaseJavaStreamApi();
        for (Person adult : adults) {
            System.out.println("Age: " + adult.getAge());
        }
    }
}
