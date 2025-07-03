import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n--- Employee Management ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        sc.nextLine(); // consume \n
                        String name = sc.nextLine();
                        System.out.print("Role: ");
                        String role = sc.nextLine();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        dao.addEmployee(new Employee(0, name, role, salary));
                        break;
                    case 2:
                        dao.viewEmployees();
                        break;
                    case 3:
                        System.out.print("Employee ID: ");
                        int id1 = sc.nextInt();
                        System.out.print("New Salary: ");
                        double newSal = sc.nextDouble();
                        dao.updateSalary(id1, newSal);
                        break;
                    case 4:
                        System.out.print("Employee ID to delete: ");
                        int id2 = sc.nextInt();
                        dao.deleteEmployee(id2);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }
}
