package Intermediate;

import java.util.List;

public class FP02Functional {
    public static void main(String[] args) {
        List<Integer> number=List.of(12,22,33,44,55,66,12,34,56,3,5,7);
        int sum=addListFunction(number);
        System.out.println(sum);

    }

    private static int addListFunction(List<Integer> number) {
        return number.stream().reduce(0,FP02Functional::Sum);
    }

    private static int printSumOfAllNumberListStructured(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);

    }

    private static Integer Sum(Integer integer, Integer integer1) {
        return integer+integer1;
    }
}
