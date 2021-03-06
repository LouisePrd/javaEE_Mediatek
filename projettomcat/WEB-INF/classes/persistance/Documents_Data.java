package persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import mediatek2022.Document;
import mediatek2022.Utilisateur;

public class Documents_Data implements Document {
	private int idDocument;
	private int id_Utilisateur;
	private String nom;
	private String type;

	public Documents_Data(int idDocument, String nom, String type, int id_Utilisateur) {
		this.idDocument = idDocument;
		this.nom = nom;
		this.type = type;
		this.id_Utilisateur = id_Utilisateur;
	}
	
	public Documents_Data() {
	}

	public static List<Document> recupDocDispo(){
		List<Document> ListeDoc = new LinkedList<Document>();
		Statement requeteStatique = null;
		ResultSet tableResultat = null;
		
		try {
			requeteStatique = Mediatheque_Data.getConnexion().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			tableResultat = requeteStatique.executeQuery("SELECT * FROM document WHERE id_Utilisateur is NULL");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (tableResultat.next()) {
				int idDocument = tableResultat.getInt("Id_Document");
				String nom = tableResultat.getString("Nom");
				String type = tableResultat.getString("type_Doc");
				int id_Utilisateur = tableResultat.getInt("id_Utilisateur");
				Documents_Data ajout = new Documents_Data(idDocument, nom, type, id_Utilisateur);
				ListeDoc.add(ajout);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ListeDoc;
	}
	
	public static Documents_Data getDocById(int id) {
		Statement requeteStatique = null;
		ResultSet tableResultat = null;
		Documents_Data ajout = new Documents_Data();
		
		try {
			requeteStatique = Mediatheque_Data.getConnexion().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			tableResultat = requeteStatique.executeQuery("SELECT * FROM document WHERE id_Document=" + id + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (tableResultat.next()) {
				int idDocument = tableResultat.getInt("id_Document");
				String nom = tableResultat.getString("Nom");
				String type = tableResultat.getString("type_Doc");
				int id_Utilisateur = tableResultat.getInt("id_Utilisateur");
				ajout = new Documents_Data(idDocument, nom, type, id_Utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ajout;
		
	}
	
	
	@Override
	public boolean disponible() {
		if (this.id_Utilisateur == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void emprunt(Utilisateur u) throws Exception {
		Statement requeteStatique = null;
		
		requeteStatique = Mediatheque_Data.getConnexion().createStatement();
		requeteStatique.executeUpdate("UPDATE document SET Id_Utilisateur =" + u.data()[0] + " WHERE id_Document=" + this.idDocument + "");
		
	}

	@Override
	public void retour() {
		Statement requeteStatique = null;
		
		try {
			requeteStatique = Mediatheque_Data.getConnexion().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			requeteStatique.executeUpdate("UPDATE document SET Id_Utilisateur = NULL WHERE id_Document=" + this.idDocument + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		String s;
		if(!this.disponible()) {
			s = "<br><br>Document id :" + this.idDocument + "<br>Nom : " + this.nom + "<br>Type : " + this.type + 
					"<br>" + "<button onclick=\"window.location.href = 'emprunt.jsp?idDocument=" + this.idDocument + "'\">Emprunter</button>";
		}
		else {
			s = "<br><br>Document id :" + this.idDocument + "<br>Nom : " + this.nom + "<br>Type : " + this.type + 
					"<br>" + "<button onclick=\"window.location.href = 'retournerPage.jsp?idDocument=" + this.idDocument + "'\">Retourner</button>";
		}
		return s;
	}
	
	public static void ajoutDoc(int type, Object... args) {
		Statement requeteStatique = null;
		String Nom = (String) args[0];
		int id_Document = (int) args[1];
		String type_Doc;
		
		switch(type) {
		  case 1:
			  type_Doc = "Livre";
			  break;
		  case 2:
			  type_Doc = "CD";
			  break;
		  case 3:
			  type_Doc = "DVD";
			  break;
		  default:
			  type_Doc = "Livre";
		}

		
		try {
			requeteStatique = Mediatheque_Data.getConnexion().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			//INSERT INTO ma_table (colonne_2, colonne_3) VALUES ('seconde', 'troisi?me')
			requeteStatique.executeUpdate("INSERT INTO document (Id_Document, Nom, type_Doc) VALUES ("+ id_Document + ", \"" + Nom + "\", \"" + type_Doc + "\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
