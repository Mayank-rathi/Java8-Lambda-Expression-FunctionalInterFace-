package Intermediate;

import java.util.List;

public class Exercise02 {
    public static void main(String[] args) {
        allCourses(List.of("Spring","Java","Html"));
    }

    private static void allCourses(List<String> spring) {
        spring.stream()
                .filter(s -> s.length() > 3)
                .map(numberOfCharacters -> numberOfCharacters.length())
                .forEach(System.out::println);
    }
}
