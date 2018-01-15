<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Entrant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Абитуриенты</title>
</head>
<body>
<h1>${hello}</h1>
<table>
    <tr>
        <th>Id</th>
        <th>ФИО</th>
        <th>Гражданство</th>
    </tr>
    <%
        ArrayList<Entrant> entrants = (ArrayList<Entrant>) request.getAttribute("entrants");

        for (Entrant entrant : entrants) {
    %>
    <tr>
        <td><%=entrant.getId()%></>
        <td><%=entrant.getFirstName()%></>
        <td><%=entrant.getCitizenship()%></>
    </tr>
    <% } %>
</table>
</body>
</html>
