package Intermediate;

import java.util.List;
import java.util.stream.Stream;

public class MinMax {
    public static void main(String[] args) {
        List<Integer> number=List.of(12,22,33,44,55,66,12,34,56,3,5,7);
        Integer reduce = number.stream()
                .map(x -> x * x * x)
                .reduce(0,Integer::sum);
        System.out.println(reduce);

    }
}
