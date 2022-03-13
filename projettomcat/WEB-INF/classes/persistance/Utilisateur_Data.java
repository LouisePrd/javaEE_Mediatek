package persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mediatek2022.Utilisateur;

public class Utilisateur_Data implements Utilisateur {
	private int id_Utilisateur;
	private String nom_Utilisateur;
	private String mdp_Utilisateur;
	private boolean estBibliothecaire;

	public Utilisateur_Data(int id_Utilisateur, String nom_Utilisateur, String mdp_Utilisateur, boolean estBibliothecaire) {
		this.id_Utilisateur = id_Utilisateur;
		this.nom_Utilisateur = nom_Utilisateur;
		this.mdp_Utilisateur = mdp_Utilisateur;
		this.estBibliothecaire = estBibliothecaire;
	}
	
	public Utilisateur_Data() {
	}

	@Override
	public String name() {
		return this.nom_Utilisateur;
	}

	@Override
	public boolean isBibliothecaire() {
		return this.estBibliothecaire;
	}

	@Override
	public Object[] data() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Utilisateur isCorrect(String login, String password) {
		Statement requeteStatique = null;
		ResultSet tableResultat = null;
		Utilisateur_Data user = new Utilisateur_Data();
		
		try {
			requeteStatique = Mediatheque_Data.getConnexion().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			tableResultat = requeteStatique.executeQuery("SELECT * FROM utilisateur WHERE nom_Utilisateur='"
		+ login + "' AND mdp_utilisateur = '" + password + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			try {
				if (!tableResultat.next()) {
					System.out.println("Connexion incorrecte");
					return null;
				} 
				else
					do {
						System.out.println("connexion effectuée");
						int id = tableResultat.getInt("Id_Utilisateur");
						String nom = tableResultat.getString("nom_Utilisateur");
						String mdp = tableResultat.getString("mdp_utilisateur");
						Boolean biblio = tableResultat.getBoolean("estBibliothecaire");
						user = new Utilisateur_Data(id, nom, mdp, biblio);
					}	
						while (tableResultat.next());
						return user;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
			
			
	}
	
	public String toString() {
		String s = "Id : " + this.id_Utilisateur + "<br><br>Login " + this.nom_Utilisateur + "<br>Mdp : " + this.mdp_Utilisateur + " biblio : " + this.isBibliothecaire();
		return s;
	}
	
}
