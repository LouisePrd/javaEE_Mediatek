package persistance;

import mediatek2022.Document;
import mediatek2022.Utilisateur;

public class Documents_Data implements Document {
//toutes les fonctions doivent récupérer les infos dans la BD

	@Override
	public boolean disponible() {
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
