<% Object voornaam = session.getAttribute("voornaam");
    String voornaamString = (voornaam != null) ? (String) voornaam : null;
%>

<html>
<body>
<h2><%= (voornaamString !=null) ? "Hallo " + voornaamString + "!" : "Hallo bezoeker"%></h2>
<a href="my">MyServlet</a><br>
<a href="registratieform.html">Registreer</a><BR>
</body>
</html>
