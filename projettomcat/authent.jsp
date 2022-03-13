<!DOCTYPE html>
<html lang="fr">
<%@ page import="mediatek2022.*" %>
<%@ page import="java.util.List" %>

    <head>
        <title>Catalogue</title>
        <meta charset="utf-8">
		
    </head>

    <body>
		<%
		String nom_Utilisateur = request.getParameter("nom");
		String mdp_utilisateur = request.getParameter("mdp");
		Mediatheque.getInstance().tousLesDocumentsDisponibles();
		%> 

		<center><H2>Bonjour <%= nom_Utilisateur %></H2> 
		<p> Bienvenue dans la mediatheque JAVA en ligne. Voici les livres disponibles :</p>
		<%List<Document> listeDoc = Mediatheque.getInstance().tousLesDocumentsDisponibles();
        for (Document doc : listeDoc) {
            out.println(doc.toString());
        }%>
		</center>

    </body>

</html>