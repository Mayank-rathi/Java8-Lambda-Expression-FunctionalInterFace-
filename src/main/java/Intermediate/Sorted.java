package Intermediate;

import java.util.Comparator;
import java.util.List;

public class Sorted {
    public static void main(String[] args) {
        List<Integer> number=List.of(12,22,33,44,55,66,12,34,56,3,5,7,33,12,22,44,22);
        number.stream()
                .filter(integer -> integer<40)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

    }
}
