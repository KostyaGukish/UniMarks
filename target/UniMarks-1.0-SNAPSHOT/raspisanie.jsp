<%@page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="styles/tables.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Расписание</title>
    <style>
        html {
            background-image: url("images/fon1.png");
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
        .entity {
            margin-left: 600px; /* Уменьшите значение здесь */
            font-size: 18px;
            color: #ffffff;
            font-family: Arial, sans-serif;
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
</div>

<div class="container">
    <div class="schedule">
        <div class="left-column">
            <table class="day-table">
                <caption>Понедельник</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>${predmet[1][1]}</td>
                    <td>${teacher[1][1]}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>
                    <td>${predmet[1][2]}</td>
                    <td>${teacher[1][2]}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>
                    <td>${predmet[1][3]}</td>
                    <td>${teacher[1][3]}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>
                    <td>${predmet[1][4]}</td>
                    <td>${teacher[1][4]}</td>
                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Вторник</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>${predmet[2][1]}</td>
                    <td>${teacher[2][1]}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>
                    <td>${predmet[2][2]}</td>
                    <td>${teacher[2][2]}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>
                    <td>${predmet[2][3]}</td>
                    <td>${teacher[2][3]}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>
                    <td>${predmet[2][4]}</td>
                    <td>${teacher[2][4]}</td>
                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Среда</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>${predmet[3][1]}</td>
                    <td>${teacher[3][1]}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>
                    <td>${predmet[3][2]}</td>
                    <td>${teacher[3][2]}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>
                    <td>${predmet[3][3]}</td>
                    <td>${teacher[3][3]}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>
                    <td>${predmet[3][4]}</td>
                    <td>${teacher[3][4]}</td>
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
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>${predmet[4][1]}</td>
                    <td>${teacher[4][1]}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>
                    <td>${predmet[4][2]}</td>
                    <td>${teacher[4][2]}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>
                    <td>${predmet[4][3]}</td>
                    <td>${teacher[4][3]}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>
                    <td>${predmet[4][4]}</td>
                    <td>${teacher[4][4]}</td>
                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Пятница</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>${predmet[5][1]}</td>
                    <td>${teacher[5][1]}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>
                    <td>${predmet[5][2]}</td>
                    <td>${teacher[5][2]}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>
                    <td>${predmet[5][3]}</td>
                    <td>${teacher[5][3]}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>
                    <td>${predmet[5][4]}</td>
                    <td>${teacher[5][4]}</td>
                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>
            <table class="day-table">
                <caption>Суббота</caption>
                <tr>
                    <th>№ пары</th>
                    <th>Время</th>
                    <th>Предмет</th>
                    <th>Преподаватель</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>8:00 - 9:30</td>
                    <td>${predmet[6][1]}</td>
                    <td>${teacher[6][1]}</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>9:45 - 11:05</td>
                    <td>${predmet[6][2]}</td>
                    <td>${teacher[6][2]}</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>11:15 - 12:35</td>
                    <td>${predmet[6][3]}</td>
                    <td>${teacher[6][3]}</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>13:00 - 14:20</td>
                    <td>${predmet[6][4]}</td>
                    <td>${teacher[6][4]}</td>
                </tr>
                <!-- Добавьте остальные строки для каждой пары -->
            </table>

            <!-- Добавьте еще две таблицы справа для остальных дней -->
        </div>
    </div>
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
