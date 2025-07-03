import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public void addEmployee(Employee e) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)");
        ps.setString(1, e.name);
        ps.setString(2, e.role);
        ps.setDouble(3, e.salary);
        ps.executeUpdate();
        conn.close();
        System.out.println("✅ Employee added.");
    }

    public void viewEmployees() throws Exception {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                               ", Name: " + rs.getString("name") +
                               ", Role: " + rs.getString("role") +
                               ", Salary: ₹" + rs.getDouble("salary"));
        }
        conn.close();
    }

    public void updateSalary(int id, double newSalary) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE employee SET salary = ? WHERE id = ?");
        ps.setDouble(1, newSalary);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        conn.close();
        System.out.println(rows > 0 ? "✅ Salary updated." : "⚠️ Employee not found.");
    }

    public void deleteEmployee(int id) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id = ?");
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        conn.close();
        System.out.println(rows > 0 ? "✅ Employee deleted." : "⚠️ Employee not found.");
    }
}
