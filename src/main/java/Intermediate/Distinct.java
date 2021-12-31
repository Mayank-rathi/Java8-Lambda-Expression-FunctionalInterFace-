package Intermediate;

import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        List<Integer> number=List.of(12,22,33,44,55,66,12,34,56,3,5,7,7,44,12,33,44);
        number.stream().distinct().forEach(System.out::println);
    }
}
