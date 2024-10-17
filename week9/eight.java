import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class eight {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
            new Employee("John", "HR", 50000),
            new Employee("Alice", "IT", 70000),
            new Employee("Bob", "HR", 55000),
            new Employee("Charlie", "IT", 80000),
            new Employee("David", "Finance", 60000)
        );

        // 1. Map: Create a list of employee names and salaries
        List<String> employeeDetails = employees.stream()
            .map(emp -> emp.getName() + " earns " + emp.getSalary())
            .collect(Collectors.toList());
        System.out.println("Employee Details: " + employeeDetails);

        // 2. Filter: Filter employees who belong to the IT department
        List<Employee> itEmployees = employees.stream()
            .filter(emp -> "IT".equals(emp.getDepartment()))
            .collect(Collectors.toList());
        System.out.println("IT Employees: " + itEmployees);

        // 3. Reduce: Calculate the average salary for employees in each department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment, 
                Collectors.averagingDouble(Employee::getSalary)
            ));
        System.out.println("Average Salary by Department: " + avgSalaryByDept);
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

