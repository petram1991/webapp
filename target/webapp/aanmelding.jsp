<%@ page import="org.example.domain.Gebruiker" %>

<% Gebruiker gebruiker = (Gebruiker) request.getAttribute("gebruiker"); %>

<html>
    <body>
        <p>Thank you <%=gebruiker.getVoornaam()%> for contacting us from <%=gebruiker.getEmail()%>!!!!</p>
        <a href="index.jsp">Home</a>
    </body>
</html>
