<%@ page language="java" %>
<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="styles/blocks.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная страница</title>
    <style>
        html {
            background-image: url("images/fon1.png");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100%;
            overflow: hidden;
        }

        /* Стили для меню */
        .menu {
            display: flex;
            align-items: center;
            background-color: #0a3470;
            padding: 20px;
        }

        .menu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
        }

        .menu ul li {
            margin-right: 30px;
            font-size: 18px;
            font-family: Arial, sans-serif;
            position: relative;
        }

        .menu ul li a {
            text-decoration: none;
            color: #ffffff;
        }

        .menu ul li a:hover {
            background-color: #ffffff; /* Удалите или закомментируйте эту строку */
            color: #17287d;
            padding: 10px 10px; /* Увеличьте значения padding по вашему выбору */
            margin: -10px -10px; /* Увеличьте значения margin по вашему выбору */
        }

        /* Стили для общего контейнера */
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            text-align: center; /* Добавлено для выравнивания по центру */
        }

        /* Стили для блоков */
        .block-container {
            display: flex;
            justify-content: space-between;
            margin-top: -500px;
        }

        .block {
            position: relative;
            width: 200px;
            height: 200px;
            margin: 20px;
            overflow: hidden;
            perspective: 1000px;
            cursor: pointer;
            transition: transform 0.3s ease;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.6);
        }

        .block:hover {
            transform: scale(1.2);
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.8);
        }

        .block-image {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .block-caption {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        /* Стили для панельки контактных данных */
        .contact-panel {
            background-color: #f2f2f2;
            padding: 10px;
            text-align: center;
            position: fixed;
            left: 0;
            right: 0;
            bottom: 0;
        }

        .contact-panel p {
            margin: 0;
        }

        /* Стили для имени пользователя */
        .username {
            margin-left: auto;
            font-size: 20px;
            margin-right: 20px;
            color: #ffffff;
            font-family: Arial, sans-serif;
        }

        /* Стили для аватара пользователя */
        .user-avatar {
            width: 50px;
            height: 50px;
            margin-left: 10px;
        }
        .page-title {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="menu">
    <a href="Page1.jsp">
        <img class="logo" src="images/favicon.png" alt="Логотип" style="width: 50px; height: 50px; margin-right: 30px;">
    </a>
    <ul>
        <li><a href=${rasp1} id="rasp">Расписание</a></li>
        <li><a href=${jorney1} id="jorney">Журнал</a></li>
    </ul>
    <p class ="username"> ${entity}</p>
    <p class ="username"> ${loggedInUser}</p>
<%--    <script>--%>
<%--        // Получение значения "loggedInUser" из локального хранилища--%>
<%--        var entity = sessionStorage.getItem('entity');--%>
<%--        if (entity === "Студент:") {--%>
<%--            document.getElementById('rasp').href = "raspisanie.jsp";--%>
<%--            document.getElementById('jorney').href = "zhurnal.jsp";--%>
<%--        } else {--%>
<%--            document.getElementById('rasp').href = entity;--%>
<%--            document.getElementById('jorney').href = "teacher-zhurnal.jsp";--%>
<%--        }--%>
<%--    </script>--%>
<%--    <%--%>
<%--        String entity = (String) session.getAttribute("entity");--%>
<%--        if (entity.equals("Студент:")) {--%>
<%--            out.print("<li><a href=\"raspisanie.jsp\" id=\"rasp\">Расписание</a></li>");--%>
<%--//            document.getElementById('rasp').href = "raspisanie.jsp";--%>
<%--//            document.getElementById('jorney').href = "zhurnal.jsp";--%>
<%--        } else {--%>
<%--            out.println("<li><a href=\"raspisanie.jsp\" id=\"rasp\">Расписание</a></li>");--%>
<%--//            document.getElementById('rasp').href = entity;--%>
<%--//            document.getElementById('jorney').href = "teacher-zhurnal.jsp";--%>
<%--        }--%>
<%--    %>--%>
    <img class="user-avatar" src="images/avatar.png" alt="Аватар">
</div>
<h1 class="page-title">БГУ это:</h1>
<div class="container">
    <div class="block-container">
        <div class="block">
            <img class="block-image" src="images/obraz.png" alt="Фото 1">
            <div class="block-caption"><centrer>Лучшее образование</centrer></div>
        </div>
        <div class="block">
            <img class="block-image" src="images/mss.jpg" alt="Фото 2">
            <div class="block-caption"><center>Лучшие преподаватели</center></div>
        </div>
        <div class="block">
            <img class="block-image" src="images/ways.jpg" alt="Фото 3">
            <div class="block-caption"><center>Новые возможности</center></div>
        </div>
        <div class="block">
            <img class="block-image" src="images/realiz.png" alt="Фото 4">
            <div class="block-caption"><center>Лучшая реализация</center></div>
        </div>
    </div>

    <div class="contact-panel">
        <p>Для получения дополнительной информации, свяжитесь с нами:</p>
        <p>Телефон поддержки: +123456789</p>
        <p>Справочный центр: +987654321</p>
    </div>
</div>

<%--<script>
    // Получение значения "loggedInUser" из локального хранилища
    var loggedInUser = sessionStorage.getItem('loggedInUser');

    // Отображение имени пользователя в меню
    var usernameElement = document.querySelector('.username');
    if (loggedInUser && usernameElement) {
        usernameElement.textContent = loggedInUser;
    }
</script>--%>


</body>
</html>
