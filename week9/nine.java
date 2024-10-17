import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class nine {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 85.5),
            new Student("Bob", 22, 90.0),
            new Student("Charlie", 19, 78.0),
            new Student("David", 23, 88.0)
        );

        // 1. Map: Create a new list containing only the names of the students
        List<String> studentNames = students.stream()
            .map(Student::getName)
            .collect(Collectors.toList());
        System.out.println("Student Names: " + studentNames);

        // 2. Filter: Filter the students who are above a certain age threshold (e.g., 21)
        List<Student> filteredStudents = students.stream()
            .filter(student -> student.getAge() > 21)
            .collect(Collectors.toList());
        System.out.println("Filtered Students: " + filteredStudents);

        // 3. Reduce: Calculate the average grade of all students
        double averageGrade = students.stream()
            .mapToDouble(Student::getGrade)
            .average()
            .orElse(0.0);
        System.out.println("Average Grade: " + averageGrade);
    }
}

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }
}

