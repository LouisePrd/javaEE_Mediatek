<!DOCTYPE html>
<html lang="fr">
<%@ page import="mediatek2022.*" %>
<%@ page import="java.util.List" %>

    <head>
        <title>Catalogue</title>
        <meta charset="utf-8">
		
    </head>

    <body><center><br>
	<h2>Bienvenue sur le service de connexion a la mediatheque.</h2><br><br>
	<form method="post" action="authent.jsp">
	<input type="text" name="nom" placeholder="Login"/><br><br>
	<input type="password" name="mdp" placeholder="Mot de passe"/><br><br>
	<input type="submit" value="Connexion"/><br>
	</form></center>
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