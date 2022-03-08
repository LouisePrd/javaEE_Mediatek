<!DOCTYPE html>
<html lang="fr">

    <head>
        <title>jsp</title>
        <meta charset="utf-8">
		<%
		Class.forName("oracle.jdbc.OracleDriver");
	
 		Connex c = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:8080:XE","root","root");
 		System.out.println("connection ok");
		

 		Statement requeteStatique = c.createStatement();
		 ResultSet tableResultat = requeteStatique.executeQuery
		  ("SELECT nom FROM pilote");
		  
		  if (!tableResultat.next())
		  System.out.println("aucun pilote dans la base avion (c'est louche)"); 
		  else do
			  System.out.println(tableResultat.getString("nom"));
		  while (tableResultat.next());
		c.close();	
		%>
    </head>

    <body>
		
    </body>

</html>