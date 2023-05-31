<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="tables.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Расписание</title>
    <style>
        html {
            background-image: url("fon1.png");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100%;
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
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
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
    <div class="schedule">
        <div class="left-column">
            <table class="day-table">
                <caption>Понедельник</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Группа</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>

                    <td>1</td>

                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Вторник</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Группа</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>

                    <td>1</td>

                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Среда</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Группа</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>

                    <td>1</td>

                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>

            <!-- Добавьте еще две таблицы слева для остальных дней -->
        </div>

        <div class="right-column">
            <table class="day-table">
                <caption>Четверг</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Группа</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>1</td>

                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>

                    <td>1</td>

                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Пятница</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Группа</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>1</td>

                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>

                    <td>1</td>

                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Суббота</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Группа</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>1</td>

                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>

                    <td>1</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>

                    <td>1</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>

                    <td>5</td>
                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>

            <!-- Добавьте еще две таблицы справа для остальных дней -->
        </div>
    </div>
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
