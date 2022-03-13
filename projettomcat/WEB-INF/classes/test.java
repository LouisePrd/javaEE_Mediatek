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

        //System.out.println(Mediatheque.getInstance());
        //System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        //System.out.println(Mediatheque.getInstance().getDocument(1));
        //System.out.println(Mediatheque.getInstance().getUser("Louis", "12345"));
        System.out.println(Mediatheque.getInstance().getUser("aaas", "12345"));
        
        /*System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        Mediatheque.getInstance().getDocument(1).emprunt(louis);
        System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        Mediatheque.getInstance().getDocument(1).retour();;
        System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());*/
	}

}
