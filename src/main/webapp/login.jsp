<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
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

<form class="box" action="Page1.html" method="post">
    <h1>Login</h1>
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="login" value="Login">
</form>

<script>
    // Обработка отправки формы
    document.querySelector('.box').addEventListener('submit', function(e) {
        e.preventDefault();

        // Получаем значения полей "username" и "password"
        var username = document.querySelector('input[name="username"]').value;
        var password = document.querySelector('input[name="password"]').value;

        // Проверяем логин и пароль
        if (username === 'Андрей Коноплич' && password === '1111') {
            // Если логин и пароль верны, сохраняем значение "username" в локальном хранилище
            localStorage.setItem('username', username);

            // Перенаправляем на страницу Page1.html
            window.location.href = 'Page1.html';
        } else {
            // Если логин или пароль неверны, отображаем всплывающее сообщение
            alert('Неверный логин или пароль');
        }
    });
</script>

</body>
</html>
