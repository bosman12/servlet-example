<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title>
        Login
    </title>
</head>
<body>

<form action="/login" method="post">
    <p>
        <input type="userName" name="userName" placeholder="Введите userName" required/>
    </p>

    <p>
        <input type="password" name="password" placeholder="Введите пароль" required/>
    </p>

    <input type="submit" value="Войти">
    <input type="reset" value="Очистить">

</form><br>

<form action="/registration" method="get">
    <input type="submit" value="Зарегистрироваться">
</form>

</body>
</html>
