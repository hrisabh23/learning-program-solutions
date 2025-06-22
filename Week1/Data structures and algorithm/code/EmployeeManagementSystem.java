
import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + employeeId +
                ", Name='" + name + '\'' +
                ", Position='" + position + '\'' +
                ", Salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {

    static final int MAX = 100;
    static Employee[] employees = new Employee[MAX];
    static int count = 0;

    // Add Employee
    public static void addEmployee(int id, String name, String position, double salary) {
        if (count < MAX) {
            employees[count++] = new Employee(id, name, position, salary);
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee list is full.");
        }
    }

    // Search Employee by ID
    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Traverse/Display All Employees
    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(employees[i]);
            }
        }
    }

    // Delete Employee by ID
    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift remaining elements left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addEmployee(101, "Alice", "Manager", 55000);
        addEmployee(102, "Bob", "Developer", 40000);
        addEmployee(103, "Charlie", "Designer", 38000);

        System.out.println("\nAll Employees:");
        traverseEmployees();

        System.out.println("\nSearch for ID 102:");
        searchEmployee(102);

        System.out.println("\nDeleting employee ID 102:");
        deleteEmployee(102);

        System.out.println("\nAll Employees after deletion:");
        traverseEmployees();
    }
}
