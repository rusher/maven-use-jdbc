import java.sql.*;

public class Main {

    public static void main(String [] args) {
        try {
            try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/testj?user=root")) {
                try (Statement statement = connection.createStatement()) {
                    try (ResultSet rs = statement.executeQuery("select 'a' from seq_1_to_1000")) {
                        while (rs.next()) {
                            rs.getString(1);
                        }
                    }
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
