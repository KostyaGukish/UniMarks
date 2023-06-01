<%@ page import="org.example.entity.TimeTable" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.action.ZhurnalAction" %>
<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="styles/zhurnal.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Журнал</title>
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
            background-color: #ffffff;
            color: #17287d;
            padding: 10px 10px;
            margin: -10px -10px;
        }

        /* Стили для общего контейнера */
        .container {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            height: 100vh;
            margin-top: 20px;
        }


        /* Стили для фотографии в тексте */
        .image-in-text {
            float: left;
            margin: 0 20px 20px 0;
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
            margin-right: 30px;
            color: #ffffff;
            font-family: Arial, sans-serif;
        }
        .entity {
            margin-left:550px; /* Уменьшите значение здесь */
            font-size: 18px;
            color: #ffffff;
            font-family: Arial, sans-serif;
        }

        /* Стили для аватара пользователя */
        .user-avatar {
            width: 50px;
            height: 50px;
            margin-left: 10px;
            margin-right: 20px;
        }
        .page-title {
            text-align: center;
        }
        .logout-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #fff;
            color: #333;
            border: 1px solid #ccc;
            border-radius: 4px;
            text-decoration: none;
            transition: background-color 0.2s;
            font-size: 18px;
            font-family: Arial, sans-serif;
        }

        .logout-button:hover {
            background-color: #e27272;
        }

        .day-table {
            /* Добавьте следующие стили для сетки таблицы */
            border-collapse: collapse;
        }

        .day-table th, .day-table td {
            /* Добавьте следующие стили для ячеек таблицы */
            border: 1px solid #000;
            padding: 8px;
        }

        .vertical-dates {
            /* Добавьте следующие стили для вертикального расположения дат */
            position: relative;
            writing-mode: vertical-lr;
            text-align: center;
        }

        .vertical-date {
            /* Добавьте следующие стили для отдельных дат */
            margin: 2px;
        }


    </style>
</head>
<body>
<div class="menu">
    <a href="Page1.jsp">
        <img class="logo" src="images/favicon.png" alt="Логотип" style="width: 50px; height: 50px; margin-right: 30px;">
    </a>
    <ul>
        <li><a href="raspisanie">Расписание</a></li>
        <li><a href="zhurnal">Журнал</a></li>
    </ul>
    <p class ="entity"> ${entity}</p>
    <p class ="username"> ${loggedInUser}</p>
    <img class="user-avatar" src="images/avatar.png" alt="Аватар">
    <a href="login.jsp" class="logout-button">Выход</a>
</div>

<div class="container">
    <table class="journal-table">
        <thead>
        <tr>
            <th>Предмет</th>
            <th>Оценки</th>
        </tr>
        </thead>
        <tbody>
        <% List<ZhurnalAction.pair> temp = (List<ZhurnalAction.pair>) request.getAttribute("temp");
            for (ZhurnalAction.pair p : temp) { %>
        <tr>
            <td><%= p.first %></td>
            <td><% for (Integer mark : p.second) { %>
                <%= mark %>
                <% } %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<script>
    // Получение значения "loggedInUser" из локального хранилища
    var loggedInUser = sessionStorage.getItem('loggedInUser');

    // Отображение имени пользователя в меню
    var usernameElement = document.querySelector('.username');
    if (loggedInUser && usernameElement) {
        usernameElement.textContent = loggedInUser;
    }
</script>
</body>
</html>
