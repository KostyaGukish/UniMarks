<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="zhurnal.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Журнал</title>
    <style>
        html {
            background-image: url("fon1.png");
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
    <a href="Page1.html">
        <img class="logo" src="favicon.png" alt="Логотип" style="width: 50px; height: 50px; margin-right: 30px;">
    </a>
    <ul>
        <li><a href="raspisanie.html">Расписание</a></li>
        <li><a href="zhurnal.html">Журнал</a></li>
    </ul>
    <span class="username"></span>
    <img class="user-avatar" src="avatar.png" alt="Аватар">
</div>

<div class="container">
    <table class="journal-table">
        <thead>
        <tr>
            <th>Предмет</th>
            <th>Оценки</th>
            <!--
            <div class="vertical-dates">
            <span class="vertical-date">01.05</span>
          </div></th>
          <th><div class="vertical-dates">
            <span class="vertical-date">02.05</span>
          </div></th>
          <th><div class="vertical-dates">
            <span class="vertical-date">03.05</span>
          </div></th>
          <th><div class="vertical-dates">
            <span class="vertical-date">04.05</span>
          </div></th>
          <th><div class="vertical-dates">
            <span class="vertical-date">05.05</span>
          </div>
        -->

            <th>Средий балл</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Математика</td>
            <td>90, 85, 95, 100, 90, 80, 85, 75, 100</td>
            <td>90</td>
        </tr>
        <tr>
            <td>Физика</td>
            <td>80, 85, 90</td>
            <td>85</td>
        </tr>
        <tr>
            <td>Философия</td>
            <td>90, 85, 95</td>
            <td>90</td>
        </tr>
        <tr>
            <td>БЖЧ</td>
            <td>90, 85, 95</td>
            <td>90</td>
        </tr>
        <tr>
            <td>Программировние</td>
            <td>90, 85, 95</td>
            <td>90</td>
        </tr>
        <!-- Add more rows for other subjects -->
        </tbody>
    </table>
</div>


<script>
    // Получаем значение "username" из локального хранилища
    var username = localStorage.getItem('username');

    // Отображаем имя пользователя в меню
    var usernameElement = document.querySelector('.username');
    if (username && usernameElement) {
        usernameElement.textContent = username;
    }
</script>
</body>
</html>
