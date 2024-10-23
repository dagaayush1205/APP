import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "daga";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String deleteSQL = "DELETE FROM employees WHERE employee_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                preparedStatement.setInt(1, 5);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

