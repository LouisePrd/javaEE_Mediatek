import mediatek2022.Mediatheque;
import mediatek2022.Utilisateur;

public class test {
//classe pour tester les fonctions
	
	public static void main(String[] args) throws Exception {
        try {
            Class.forName("persistance.Mediatheque_Data");
            System.out.println("trouvee");
        } catch (ClassNotFoundException e) {
            System.out.println("non trouvee");
        }

        //Test du fonctionnement des docs
        //System.out.println(Mediatheque.getInstance());
        //System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        
        
        //Test de l'emprunt et du retour
        /*Utilisateur user = Mediatheque.getInstance().getUser("Louise", "1234");
        
        System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        Mediatheque.getInstance().getDocument(1).emprunt(user);
        System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        Mediatheque.getInstance().getDocument(1).retour();;
        System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());*/
        
        //Test de l'ajout
        /*System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        Object[] args2 = new Object[2];
        args2[0] = "La Nuit des Temps";
        args2[1] = 5;
        Mediatheque.getInstance().ajoutDocument(1, args2);
        System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());*/
	}

}
