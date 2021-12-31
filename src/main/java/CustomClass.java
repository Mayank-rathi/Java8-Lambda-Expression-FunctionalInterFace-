import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.*;

class Course{
 private String name;
 private String category;
 private int reviewScore;
 private int noOfStudent;

     public Course(String name, String category, int reviewScore, int noOfStudent) {
         this.name = name;
         this.category = category;
         this.reviewScore = reviewScore;
         this.noOfStudent = noOfStudent;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getCategory() {
         return category;
     }

     public void setCategory(String category) {
         this.category = category;
     }

     public int getReviewScore() {
         return reviewScore;
     }

     public void setReviewScore(int reviewScore) {
         this.reviewScore = reviewScore;
     }

     public int getNoOfStudent() {
         return noOfStudent;
     }

     public void setNoOfStudent(int noOfStudent) {
         this.noOfStudent = noOfStudent;
     }

     @Override
     public String toString() {
         return "Course{" +
                 "name=" + name +
                 ", reviewScore=" + reviewScore +
                 ", noOfStudent=" + noOfStudent +
                 '}';
     }
 }

public class CustomClass {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "FrameWork", 98, 20000),
                new Course("Spring Boot", "FrameWork", 95, 18000),
                new Course("Api", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 22000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<Course> courseGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> courseGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> courseLessThan90Predicate = course -> course.getReviewScore() < 90;

        //For ReviewScore
        System.out.println(courses.stream().anyMatch(courseGreaterThan90Predicate));
        System.out.println(courses.stream().noneMatch(courseLessThan90Predicate));
        System.out.println(courses.stream().allMatch(courseGreaterThan90Predicate));
        System.out.println(courses.stream().allMatch(courseGreaterThan95Predicate));
        System.out.println("-------------ReviewScore------------------------");

        //For noOfStudent
        System.out.println(courses.stream().allMatch(course -> course.getNoOfStudent()>5000));
        System.out.println(courses.stream().allMatch(course -> course.getNoOfStudent()<15000));
        System.out.println(courses.stream().anyMatch(course -> course.getNoOfStudent()>5000));
        System.out.println(courses.stream().noneMatch(course -> course.getNoOfStudent()>35000));

        //Sorted For NoOfStudent Increasing Order
       /* Comparator<Course> courseComparator = Comparator.comparing(Course::getNoOfStudent);
        System.out.println(courses.stream().sorted(courseComparator).collect(Collectors.toList()));*/
        System.out.println(courses
                .stream()
                .sorted(Comparator
                        .comparing(Course::getNoOfStudent))
                .collect(Collectors.toList()));

        //Sorted For NoOfStudent Decreasing Order
        /*Comparator<Course> courseComparatorDecreasing = Comparator.comparing(Course::getNoOfStudent);
        System.out.println(courses.stream().sorted(courseComparatorDecreasing.reversed()).collect(Collectors.toList()));*/

        System.out.println(courses
                .stream()
                .sorted(Comparator
                        .comparing(Course::getNoOfStudent)
                        .reversed())
                .collect(Collectors.toList()));

        //Sorted For NoOfStudent And Then ReviewScore Increasing Order
        Comparator<Course> courseComparatorThenCompareWithReviewScore
                                        = Comparator.comparing(Course::getNoOfStudent);
        System.out.println(courses
                .stream()
                .sorted(courseComparatorThenCompareWithReviewScore
                        .thenComparing(Course::getReviewScore)
                        .reversed())
                .collect(Collectors.toList()));

        System.out.println(courses
                .stream()
                .sorted(Comparator.comparing(Course::getNoOfStudent).thenComparing(Course::getReviewScore))
                .collect(Collectors.toList()));

        System.out.println("----------------End For Score-------------------");
        //Sorted For CourseName Increasing Order
        System.out.println(courses
                .stream()
                .sorted(Comparator.comparing(Course::getName)).collect(Collectors.toList()));

        //Sorted For NoOfStudent Increasing Order Then NoOfStudent
        System.out.println(courses
                .stream()
                .sorted(Comparator.comparing(Course::getName)
                        .thenComparing(Course::getNoOfStudent).reversed())
                .collect(Collectors.toList()));
        System.out.println("--------------Limit Start-------------------------------");
        //Limit
        Comparator<Course> courseComparatorIncreasing = Comparator.comparing(Course::getNoOfStudent);
        System.out.println(courses
                .stream()
                .sorted(courseComparatorIncreasing.reversed()).limit(1)
                .collect(Collectors.toList()));
        System.out.println("----------Skip Start---------------");
        //Skip
        Comparator<Course> courseComparatorIncreasingForSkip = Comparator.comparing(Course::getNoOfStudent);
        System.out.println(courses
                .stream()
                .sorted(courseComparatorIncreasingForSkip.reversed())
                .skip(2)
                .limit(2)
                .collect(Collectors.toList()));

        System.out.println("-----------------Take While------------------");
        //TakeWhile
        System.out.println(courses
                .stream()
                .takeWhile(course -> course.getReviewScore() >= 95)
                .collect(Collectors.toList()));

        System.out.println("-------------DropWhile-----------------");
        System.out.println(courses);
        //dropWhile
        System.out.println(courses
                .stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));

        //Min And Max
        System.out.println("------------------------MinAndMax--------------------");
        System.out.println(courses
                .stream()
                .max(Comparator.comparing(Course::getNoOfStudent)));

        System.out.println(courses
                .stream()
                .min(Comparator.comparing(Course::getNoOfStudent)));

        System.out.println(courses
                .stream()
                .max(Comparator.comparing(Course::getNoOfStudent).thenComparing(Course::getReviewScore)));

        //Sum,average,count
        System.out.println(courses
                .stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNoOfStudent)
                .sum());

        System.out.println(courses
                .stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNoOfStudent)
                .average());

        System.out.println(courses
                .stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNoOfStudent)
                .count());

        System.out.println(courses
                .stream()
                .filter(course -> course.getReviewScore()>95)
                .mapToInt(Course::getNoOfStudent)
                .max());
        //Grouping
        System.out.println("---------------GroupBy----------------");
      /*  System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));

        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory
                        ,Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName,Collectors.toList()))));*/

        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));

        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors
                        .mapping(Course::getName,Collectors.toList()))));
        System.out.println(courses
                .stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(
                        Comparator.comparing(Course::getReviewScore)
                ))));

        //Stream
        System.out.println("-----------StreamFunction-------------");
        System.out.println(Stream.of(1,22,33,44,66).count());
        System.out.println(Stream.of(1,22,33,44,66).reduce(0,Integer::sum));
        System.out.println(Stream.of(1,22,33,44,66).reduce(0,Integer::max));
        System.out.println(Stream.of(1,22,33,44,66).reduce(0,Integer::min));

        //IntStream
        System.out.println(IntStream.range(0,55).sum());
        System.out.println(IntStream.range(0,55).average());
        System.out.println(IntStream.rangeClosed(1,55).sum());
        System.out.println(IntStream.iterate(1,e-> e+2).limit(10).sum());
        //System.out.println(IntStream.iterate(1,e-> e+2).limit(10).peek(System.out::println).sum());
        //System.out.println(IntStream.iterate(2,e-> e*2).limit(10).peek(System.out::println).sum());
        System.out.println(IntStream.iterate(2,e-> e*2).limit(10).boxed().collect(Collectors.toList()));

        //Calculate Big Number
        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger
                .ONE,BigInteger::multiply));


        Predicate<Course> reviewScoreGraterThan90=
                getCoursePredicate(95);


    }

    private static Predicate<Course> getCoursePredicate(int i) {
        Predicate<Course> coursePredicate = course -> course.getReviewScore() > i;
        return coursePredicate;
    }
}
