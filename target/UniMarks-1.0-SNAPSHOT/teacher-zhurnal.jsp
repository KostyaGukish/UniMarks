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
            min-height: 100%;
        }

        /* Стили для таблицы */
        .journal-table {
            border-collapse: collapse;
            margin-top: 20px;
            max-width: 500px; /* Измените значение ширины по вашему желанию */
            width: 100%;
        }

        .journal-table th,
        .journal-table td {
            border: 1px solid #000;
            padding: 8px;
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

        /* Стили для колонки "Студент" */
        .student-column {
            width: 70%; /* Измените значение ширины по вашему желанию */
        }

        /* Стили для колонки "Выставить отметку" */
        .grade-column {
            width: 30%; /* Измените значение ширины по вашему желанию */
        }

        .group-heading {
            font-size: 26px;
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
    <p class ="entity"> ${entity}</p>
    <p class ="username"> ${loggedInUser}</p>
    <img class="user-avatar" src="images/avatar.png" alt="Аватар">
    <a href="login.jsp" class="logout-button">Выход</a>
</div>

<h1 class="group-heading"><center>Группа 1</center></h1>
<div class="container">
    <table class="journal-table">
        <thead>
        <tr>
            <th>Номер</th>
            <th class="student-column">Студент</th>
            <th class="grade-column">Выставить отметку</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Студент 1</td>
            <td contenteditable="true"></td>
        </tr>
        <tr>
            <td>2</td>
            <td>Студент 2</td>
            <td contenteditable="true"></td>
        </tr>
        <!-- Добавьте остальные строки для студентов группы 1 -->
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