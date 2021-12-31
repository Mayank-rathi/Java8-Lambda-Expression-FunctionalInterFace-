package Intermediate;

import java.util.List;

public class FP01Structured {
        public static void main(String[] args) {
                printAllNumberListStructured(List.of(12,22,33,44,55,66,12,34,56,3,5,7));
        }

        /*private static void print(int number){
                System.out.println(number);
        }*/
        /*private static void printAllNumberListStructured(List<Integer> integers) {
                integers
                        .stream()
                        .forEach(System.out::println);
        }*/
        private static void printAllNumberListStructured(List<Integer> integers) {
                integers.stream()
                        .filter(integer -> integer % 2 != 0)
                        .map(number -> number * number * number)
                        .forEach(System.out::println);
        }
}
