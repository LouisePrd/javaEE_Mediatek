<!DOCTYPE html>
<html lang="fr">
<%@ page import="mediatek2022.*" %>
<%@ page import="java.util.List" %>
<%@ page import = "java.io.*,java.util.*" %>

    <head>
        <title>Catalogue</title>
        <meta charset="utf-8">
		
    </head>

    <body>
		<%
		Utilisateur user;
		if (session.getAttribute("utilisateurCourant") == null){	
			String nom_Utilisateur = request.getParameter("nom");
			String mdp_utilisateur = request.getParameter("mdp");
			user = Mediatheque.getInstance().getUser(nom_Utilisateur, mdp_utilisateur);
		
			if (Mediatheque.getInstance().getUser(nom_Utilisateur, mdp_utilisateur) == null){%>
				<center><br><h2>Erreur de connexion : mot de passe ou login incorrect<h2><br>
				<button onclick="window.location.href = 'index.jsp';">Reessayer</button></center>
				<%
			}
			else{ 
				session.setAttribute("utilisateurCourant", user) ;
			}
		}
		else{
			user = (Utilisateur)session.getAttribute("utilisateurCourant");
		}%>
		
		<center><H2>Bonjour <%= user.name() %> !</H2> <br>
			<%if (!user.isBibliothecaire()){
			out.println("tu n'es pas bibliothecaire !");%>
			<p> Bienvenue dans la mediatheque JAVA en ligne. Vous etes abonne, voici les livres disponibles :
                <%List<Document> listeDoc = Mediatheque.getInstance().tousLesDocumentsDisponibles();
                for (Document doc : listeDoc) {
                    out.println(doc.toString());
                }
			}
			else{
			out.println("tu es bibliothecaire !");
			}%></p>
		
		

		<button onclick="window.location.href = 'index.jsp';">Se deconnecter</button></center>

    </body>
	
	
	
	<style>
	p{
		font-size : 1.6em;
	}
	h2{
		font-size : 1.8em;
	}
	html {
		background-color : #88b8e4;
	}
	</style>

</html>