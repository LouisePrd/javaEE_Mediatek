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
	private String nom;
	private String auteur;
	private String etat;

	public Documents_Data(int idDocument, String titre, String auteur, String etat, boolean emprunte) {
		this.idDocument = idDocument;
		this.nom = titre;
		this.auteur = auteur;
		this.etat = etat;
	}
	
	public static List<Document> recupDoc(){
		List<Document> ListeDoc = new LinkedList<Document>();
		
		Statement requeteStatique = null;
		ResultSet tableResultat = null;
		
		try {
			requeteStatique = ConnecteurData.getConnexion().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			tableResultat = requeteStatique.executeQuery("SELECT * FROM Document");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (tableResultat.next()) {
				int idDocument = tableResultat.getInt("idDocument");
				String titre = tableResultat.getString("titre");
				String auteur = tableResultat.getString("auteur");
				boolean emprunte = tableResultat.getBoolean("emprunte");
				String etat = tableResultat.getString("etat");
				Documents_Data ajout = new Documents_Data(idDocument, titre, auteur, etat, emprunte);
				ListeDoc.add(ajout);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (requeteStatique != null)
			try {
				requeteStatique.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (tableResultat != null)
			try {
				tableResultat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return ListeDoc;
	}
	
	public Documents_Data getDocById(int id) {
		Statement requeteStatique = null;
		ResultSet tableResultat = null;
		
		return null;
		
	}
	
	
	@Override
	public boolean disponible() {
		//if (Utilisateur_Data.)
		// si pas d'utilisateur en clé étrangère : null
		return false;
	}

	@Override
	public void emprunt(Utilisateur u) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retour() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return null;
		//return en fonction des infos du doc
	}

}
