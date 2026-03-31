import java.util.*;
import java.util.stream.Collectors;

public class StreamsTask {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        class Student {
            String name;
            String department;
            double grade;

            // Constructor + Getters
            Student(String name, String department, double grade) {
                this.name = name;
                this.department = department;
                this.grade = grade;
            }

            public String getName() { return name; }
            public String getDepartment() { return department; }
            public double getGrade() { return grade; }
        }

        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );

        class Employee {
            String name;
            int age;
            String department;
            double salary;

            // Constructor + Getters
            Employee(String name, int age, String department, double salary) {
                this.name = name;
                this.age = age;
                this.department = department;
                this.salary = salary;
            }

            public String getName() { return name; }
            public int getAge() { return age; }
            public String getDepartment() { return department; }
            public double getSalary() { return salary; }
        }

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );

        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );

        //🔹 Basic Stream Operations
        List<Integer> evenNumbers =  numbers.stream().filter(n -> n%2==0).toList();
        //------------------
        List<String> namesStartWithA = names.stream().filter(Objects::nonNull).filter(name -> name.startsWith("A")).toList();
        //------------------
        List<String> upperCaseNames = names.stream().filter(name -> name!=null && !name.isEmpty()).map(String::toUpperCase).toList();
        //------------------
        List<Integer> decsList = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        //------------------
        List<Integer> uniList = numbers.stream().distinct().toList();


        //🔹 Intermediate Stream Tasks
        long numOfStr = names.stream().filter(Objects::nonNull).filter(name ->name.length()>5).count();
        //------------------
        Optional<String> firstNameStartWithK = names.stream().filter(Objects::nonNull).filter(name -> name.startsWith("A")).findFirst();
        //------------------
        Optional<Integer> devBy5 = numbers.stream().filter(num -> num%5==0).findAny();
        //------------------
        Set<String> setNames = names.stream().collect(Collectors.toSet());
        //------------------
        List<Integer> skipFirst3 = numbers.stream().skip(3).toList();


        //🔹 Numeric Streams & Reductions
        int sumNums = numbers.stream().reduce(0,Integer::sum);
        //------------------
        Optional<Integer> maxNum = numbers.stream().reduce(Integer::max);
        Optional<Integer> minNum = numbers.stream().reduce(Integer::min);
        //------------------
        OptionalDouble avgNUms = numbers.stream().mapToDouble(Integer::doubleValue).average();
        //------------------
        int mulNums  =  numbers.stream().filter(num -> num!=0).reduce(1,(a,b) -> a*b);
        //------------------
        long cntPositive = numbers.stream().filter(num -> num>0).count();

        //🔹 Collectors & Grouping
        Map<String,List<String>> studentOfDepartment = students.stream().
                collect(Collectors.groupingBy(Student::getDepartment ,
                        Collectors.mapping(Student::getName,
                                Collectors.toList())));
        //------------------
        Map<Boolean,List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(num -> num%2==0));
        List<Integer> evenGroup = partition.get(true);
        List<Integer> oddGroup = partition.get(false);
        //------------------
        String allString =  names.stream().filter(name -> name!= null && !name.isEmpty()).collect(Collectors.joining("  , "));
        //------------------
        Map<Integer,Long> numAges = employees.stream().collect(Collectors.groupingBy(
                Employee::getAge,
                Collectors.counting()
        ));
        //------------------
        Map<String,Double> avgSalaryPerDepartment = employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
        ));


        //🔹 Optional, Map, FlatMap
        List<String> flattenList = nestedWords.stream().flatMap(Collection::stream).toList();
        //------------------
        List<String> uniChars = nestedWords.stream().flatMap(Collection::stream).flatMap(s -> Arrays.stream(s.split(""))).distinct().toList();
        //------------------
        List<String> optionalList =names.stream().filter(Objects::nonNull).filter(name -> !name.isEmpty()).toList();
        //------------------
        Map<Integer,List<String>> strLen = names.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(
            String::length,
            Collectors.toList()
        ));
        //------------------
        List<String> upperAList = names.stream().filter(Objects::nonNull).filter(name -> name.startsWith("A")).map(String::toUpperCase).toList();


        //🔹 Advanced Operations
        List<Employee> sortEmployee  = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName)).toList();
        //------------------
        int secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow(() -> new RuntimeException("list is empty"));
        //------------------
        Set<Integer> item = new HashSet<>();
        List<Integer>duplicatedNum = numbers.stream().filter(num -> !item.add(num)).toList();
        //------------------
        List<String> listOfNotNull = names.stream().filter(Objects::nonNull).filter(name -> !name.isEmpty()).toList();
        //------------------
        Map<Boolean,List<String>> grads = students.stream().collect(Collectors.partitioningBy( student -> student.getGrade()>50, Collectors.mapping(Student::getName , Collectors.toList())));
        List<String> studentPassed = grads.get(true);
        List<String> studentFailed = grads.get(false);


    }
}