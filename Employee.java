public class Employee {
    int id;
    String name;
    String role;
    double salary;

    public Employee(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Role: " + role + ", Salary: ₹" + salary;
    }
}
