import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Joint {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Java", "Html", "Spring boot", "Pcd", "Azure", "Docker", "Api");
        List<String> courses2 = List.of("Spring", "Java", "Html", "Spring boot", "Pcd", "Azure", "Docker", "Api");

        System.out.println(courses.stream().collect(Collectors.joining(",")));

        System.out.println(courses.stream()
                .map(course->course.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()));

        System.out.println(courses
                .stream()
                .flatMap(s -> courses2.stream().map(s1->List.of(s,s1))).collect(Collectors.toList()));

        System.out.println(courses
                .stream()
                .flatMap(s -> courses2.stream().map(s1->List.of(s,s1)).filter(strings ->
                        strings.get(0)!=strings.get(1))).collect(Collectors.toList()));


    }
}
