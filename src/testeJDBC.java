import java.sql.Connection;
import java.sql.SQLException;

import connectionFactory.ConnectionFactory;

public class testeJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();	
	
		
	}
	
	

}
