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
		
		<%int id_Document = Integer.parseInt(request.getParameter("id_Document"));
		String Nom = request.getParameter("Nom");
		String type_Doc = request.getParameter("type_Doc");
		int typeA;
		
		switch(type_Doc) {
		  case "Livre":
			  typeA = 1;
			  break;
		  case "CD":
			  typeA = 2;
			  break;
		  case "DVD":
			  typeA = 3;
			  break;
		  default:
			  typeA = 1;
		}
		
		Object[] args2 = new Object[2];
        args2[0] = Nom;
        args2[1] = id_Document;
		
		Mediatheque.getInstance().ajoutDocument(typeA, args2);
		response.sendRedirect("authent.jsp");
		%>


    </body>
	
	
	
	<style>
	p, input{
		font-size : 1.2em;
	}
	h2{
		font-size : 1.9em;
	}
	html {
		background-color : #88b8e4;
	}
	</style>

</html>