import mediatek2022.Mediatheque;

public class test {
//classe pour tester les fonctions
	
	public static void main(String[] args) {
        try {
            Class.forName("persistance.Mediatheque_Data");
            //System.out.println("trouvee");
        } catch (ClassNotFoundException e) {
            System.out.println("non trouvee");
        }

        //System.out.println(Mediatheque.getInstance());
        //System.out.println(Mediatheque.getInstance().tousLesDocumentsDisponibles());
        //System.out.println(Mediatheque.getInstance().getDocument(1));
        System.out.println(Mediatheque.getInstance().getUser("Louis", "12345"));
	}

}
