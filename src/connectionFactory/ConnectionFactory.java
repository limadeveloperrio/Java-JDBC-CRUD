package connectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/jdbcteste", "root", "123456789");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
