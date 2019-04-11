package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Databaseconnect {
	public Connection setConnection(Connection conn1) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
          conn1 = DriverManager.getConnection("jdbc:mysql://localhost/bakerymanagement?useSSL=true", "root", "");
         } catch (SQLException e) {
			System.err.println("SQl Exception");
			e.printStackTrace();
        }
       return conn1;

	}

}


