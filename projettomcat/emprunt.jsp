<!DOCTYPE html>
<html lang="fr">
<%@ page import="mediatek2022.*" %>
<%@ page import="java.util.List" %>

    <head>
        <title>Catalogue</title>
        <meta charset="utf-8">
    </head>

    <body>
	<center><br>
	
	<%String idDocument = request.getParameter("idDocument");
	
	if(idDocument == null){
		response.sendRedirect("authent.jsp");
	}
	
	Document doc = Mediatheque.getInstance().getDocument(Integer.parseInt(idDocument));
	doc.emprunt((Utilisateur)session.getAttribute("utilisateurCourant"));
	response.sendRedirect("authent.jsp");
	%>

	</center>
    </body>
	
	<style>
	h2{
		font-size : 1.8em;
	}
	input {
		font-size : 1.6em;
	}
	html {
		background-color : #88b8e4;
	}
	</style>

</html>