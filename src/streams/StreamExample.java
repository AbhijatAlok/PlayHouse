package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // Using a stream to filter and print elements that contain the letter 'a'
        strings.stream()
                .filter(s -> s.contains("a"))
                .forEach(System.out::println);

        System.out.println(strings.stream().filter(x->x.length() < 6).collect(Collectors.joining("-")));
    }
}

