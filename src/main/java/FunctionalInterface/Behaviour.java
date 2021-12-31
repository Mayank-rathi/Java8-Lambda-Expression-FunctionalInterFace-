package FunctionalInterface;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Behaviour {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //extracted(numbers, x -> x * x);
        List<Integer> fourthRoot = extracted(numbers, x -> x * x * x * x);
        List<Integer> doubleNumber = extracted(numbers, x -> x +x);

        System.out.println(doubleNumber);
    }

    private static List<Integer> extracted(List<Integer> numbers, Function<Integer, Integer> logicForFunction) {
        return numbers.stream()
                .map(logicForFunction)
                .collect(Collectors.toList());

    }
}
