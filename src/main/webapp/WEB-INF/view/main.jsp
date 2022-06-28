<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>

</head>
<body>

<h2>all users</h2><br />

<c:forEach var="user" items="${requestScope.users}">
<ul>
    <li>id: <c:out value="${user.id}"/></li>

    <li>Имя: <c:out value="${user.name}"/></li>

    <li>Фамилия: <c:out value="${user.surName}"/></li>

    <li>Возраст: <c:out value="${user.age}"/></li>
</ul>
    <hr />

</c:forEach>
</body>
</html>