package persistance;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mediatek2022.*;

public class Mediatheque_Data implements PersistentMediatheque {
	
	static {
		Mediatheque.getInstance().setData(new Mediatheque_Data());	
	}
	
	private static Connection c;
	
	private Mediatheque_Data() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_pj", "root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Document> tousLesDocumentsDisponibles() {
		return Documents_Data.recupDocDispo();
	}

	@Override
	public Document getDocument(int numDocument) {
		return Documents_Data.getDocById(numDocument);
	}

	@Override
	public Utilisateur getUser(String login, String password) {
		//va tester si l'utilisateur est correct
		return Utilisateur_Data.isCorrect(login, password) ;
	}

	@Override
	public void ajoutDocument(int type, Object... args) {
		Documents_Data.ajoutDoc(type, args);
	}
	
	public static Connection getConnexion() {
		return c;
	}

}
