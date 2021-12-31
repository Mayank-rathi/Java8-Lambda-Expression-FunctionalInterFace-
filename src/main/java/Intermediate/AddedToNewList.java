package Intermediate;

import java.util.List;
import java.util.stream.Collectors;

public class AddedToNewList {
    public static void main(String[] args) {
        List<Integer> number=List.of(12,22,33,44,55,66,12,34,56,3,5,7,7,44,12,33,44);
        List<Integer> collect = number.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
