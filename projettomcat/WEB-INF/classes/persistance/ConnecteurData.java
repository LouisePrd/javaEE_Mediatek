package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecteurData {
	
	static {
		try {
			ConnecteurData.connexionDB();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection c;

	private static void connexionDB() throws ClassNotFoundException, SQLException {
		// chargement du driver
		Class.forName("oracle.jdbc.OracleDriver");

		// Connexion
		Connection c = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","etudiant","ETUDIANT");
 		System.out.println("connection ok");
	}
	
	public static Connection getConnexion() {
		return c;
	}
}
