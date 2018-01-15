<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>${hello}</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Гражданство</th>
    </tr>
    <c:forEach items="${entrants}" var="entrant">
        <tr>
            <td>${entrant.id}</td>
            <td>${entrant.firstName}</td>
            <td>${entrant.citizenship}</td>
        </tr>
    </c:forEach>
</table>
<form action="/entrants_as_jsp" method="post">
    <input type="text" name="firstName" placeholder="Имя">
    <input type="text" name="citizenship" placeholder="Гражданство">
    <input type="submit">
</form>
</body>
</html>
