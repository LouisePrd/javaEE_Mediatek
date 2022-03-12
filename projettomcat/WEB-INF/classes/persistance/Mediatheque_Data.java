package persistance;

import java.util.List;


import mediatek2022.*;

public class Mediatheque_Data implements PersistentMediatheque {
	
	@Override
	public List<Document> tousLesDocumentsDisponibles() {
		return Documents_Data.recupDoc();
	}

	@Override
	public Document getDocument(int numDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUser(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajoutDocument(int type, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	

}
