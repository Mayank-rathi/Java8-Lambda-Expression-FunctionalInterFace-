package practice;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Customer{
    private String CName;
    private Integer Cid;
    private String Location;
    private String Department;

    public Customer(String CName, Integer cid, String location, String department) {
        this.CName = CName;
        Cid = cid;
        Location = location;
        Department = department;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public Integer getCid() {
        return Cid;
    }

    public void setCid(Integer cid) {
        Cid = cid;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CName='" + CName + '\'' +
                ", Cid=" + Cid +
                ", Department='" + Department + '\'' +
                '}';
    }
}
public class Customers {
    public static void main(String[] args) {
        List<Customer> customers=List.of(
                new Customer("Mayank",1,"Bengluru","SoftwareDeveloper"),
                new Customer("Ram",2,"Bengluru","SoftwareDeveloper"),
                new Customer("Rakesh",3,"Mumbai","SoftwareTester"),
                new Customer("Rohan",4,"Mumbai","SoftwareTester"),
                new Customer("Hoho",5,"Pune","SoftwareTester"),
                new Customer("Lokesh",6,"Pune","SoftwareTester"),
                new Customer("Mala",7,"Bengluru","SoftwareSupport"),
                new Customer("Neel",9,"Bengluru","SoftwareSupport")
        );

        Predicate<Customer> customerPredicate = customer -> customer.getCid() > 3;
        System.out.println(customers.stream().anyMatch(customerPredicate));

        System.out.println(customers
                .stream()
                .max(Comparator.comparing(Customer::getCid)));

        System.out.println(customers
                .stream()
                .min(Comparator.comparing(Customer::getCid)));

        System.out.println(customers
                .stream()
                .collect(Collectors.toList()));

        System.out.println("----------AllMatch------------------");
        System.out.println(customers
                .stream()
                .allMatch(customer -> customer.getDepartment().equals("Mumbai")));

        System.out.println("----------AnyMatch------------------");
        System.out.println(customers
                .stream()
                .anyMatch(customer -> customer.getDepartment().equals("Mumbai")));

        System.out.println("----------NonMatch------------------");
        System.out.println(customers
                .stream()
                .noneMatch(customer -> customer.getDepartment().equals("Mumbai")));

        System.out.println("-------------Sorted---------------------");
        System.out.println(customers
                .stream()
                .sorted(Comparator.comparing(Customer::getCid))
                .collect(Collectors.toList()));
        System.out.println(customers
                .stream()
                .sorted(Comparator.comparing(Customer::getCid).reversed())
                .collect(Collectors.toList()));

        System.out.println("--------------------");
        System.out.println(customers
                .stream()
                .sorted(Comparator.comparing(Customer::getCid)
                        .thenComparing(Customer::getCName))
                .collect(Collectors.toList()));

        System.out.println(customers
                .stream()
                .sorted(Comparator.comparing(Customer::getCid)
                        .thenComparing(Customer::getCName).reversed())
                .collect(Collectors.toList()));

        System.out.println("-----------Limit-----------------");
        System.out.println(customers
                .stream()
                .sorted(Comparator.comparing(Customer::getCid))
                .limit(2)
                .collect(Collectors.toList()));

        System.out.println("-------------Skip---------");
        System.out.println(customers
                .stream()
                .sorted(Comparator.comparing(Customer::getCid))
                .skip(2)
                .limit(2)
                .collect(Collectors.toList()));
        System.out.println("---------------TakeWhile-----------");
        System.out.println(customers
                .stream()
                .takeWhile(c1 -> c1.getCid() == 1)
                .collect(Collectors.toList()));

        System.out.println("---------------DropWhile-----------");
        System.out.println(customers
                .stream()
                .dropWhile(c1 -> c1.getCid() <= 1)
                .collect(Collectors.toList()));

        System.out.println("------------Min-----------------");
        System.out.println(customers
                .stream()
                .min(Comparator.comparing(Customer::getCid)));

        System.out.println("------------Max-----------------");
        System.out.println(customers
                .stream()
                .max(Comparator.comparing(Customer::getCid)));

        System.out.println("------------Sum-----------------");
        System.out.println(customers
                .stream()
                .mapToInt(Customer::getCid)
                .sum());

        System.out.println("------------Average-----------------");
        System.out.println(customers
                .stream()
                .mapToInt(Customer::getCid)
                .average());

        System.out.println("------------Count-----------------");
        System.out.println(customers
                .stream()
                .mapToInt(Customer::getCid)
                .count());

        System.out.println("------------GroupingBy---------------");

        System.out.println(customers
                .stream()
                .limit(2)
                .collect(Collectors.groupingBy(Customer::getDepartment)));

        System.out.println(customers
                .stream()
                .filter(customer -> customer.getCid()>=1)
                .collect(Collectors.groupingBy(Customer::getDepartment)));


    }
}
