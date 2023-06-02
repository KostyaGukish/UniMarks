<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вход в учётную запись</title>
    <link rel="stylesheet" href="styles/style.css">
</head>
<style>
    html {
        background-image: url("images/fon1.png");
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        height: 100%;
    }
</style>
<body>

<form class="box"  action="/LoginServlet" method="post">
    <h1>Login</h1>
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="login" value="Login">
</form>

<script>
    // Отключение кнопок навигации
    history.pushState(null, null, 'login.jsp');
    window.addEventListener('popstate', function (event) {
        history.pushState(null, null, 'login.jsp');
    });
</script>

<%-- Проверка наличия ошибки и отображение сообщения об ошибке --%>
<% if (request.getAttribute("javax.servlet.error.message") != null) { %>
<script>
    alert("<%= request.getAttribute("javax.servlet.error.message") %>");
</script>
<% } %>

</body>
</html>
