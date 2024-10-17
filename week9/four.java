 import java.util.ArrayList;
import java.util.List;

public class four {
    public static void main(String[] args) {
        // Create an empty list of students
        List<Student> students = new ArrayList<>();
        
        // Add new students using the mutable function
        MutableFunction.addStudent(students, "Alice", 20, 85.5);
        MutableFunction.addStudent(students, "Bob", 22, 90.0);
        MutableFunction.addStudent(students, "Charlie", 19, 78.0);
        
        // Print the student list after adding students
        for (Student student : students) {
            System.out.println(student.name + " - Age: " + student.age + ", Grade: " + student.grade);
        }

        // Calculate and print the average age using the immutable function
        double averageAge = ImmutableFunction.findAverageAge(students);
        System.out.println("Average Age: " + averageAge);
    }
}

class Student {
    String name;
    int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class MutableFunction {
    // Mutable function to add a new student to the list
    public static void addStudent(List<Student> students, String name, int age, double grade) {
        students.add(new Student(name, age, grade));
    }
}

class ImmutableFunction {
    // Immutable function to calculate the average age of students
    public static double findAverageAge(List<Student> students) {
        return students.stream().mapToInt(student -> student.age).average().orElse(0.0);
    }
}
 
