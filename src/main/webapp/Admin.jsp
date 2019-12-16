<%@ page import="ru.nsu.flowerstore.Data" %><%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 10.12.2019
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <style>
        input[type="text"]{
            width: 300px;
            height:50px;
            font-size: 18px;
            margin-left: 25%;
            margin-bottom: 25px;
            border-radius: 4px;
            padding-left: 40px;
            font-family: "Helvetica", fantasy;
            position: center;

        }
        .dws-input input:hover{
            box-shadow: 0 0 6px 3px #000000;
        }
        .dws-submit {
            padding: 13px 30px;
            margin: 5px 0 20px 50%;
            font-size: 15px;
            color: #ffffff;
            background-color: #000000;
            border: none;
            cursor: pointer;
        }
        .dws-submit:hover{
            transition: all 0.5s;
            background: #fff;
            color: #2c536c;
        }
        .container{
            width:450px;
            background-color: #4CAF50;
            margin: 100px auto 0 auto;
            text-align: center;
            padding-bottom: 20px;
        }

        /*.dws-input::before{*/
        /*    font-family: Helvetica, fantasy;*/
        /*    content: "\f007";*/
        /*    position: absolute;*/
        /*    font-size: 30px;*/
        /*    padding: 10px 0 0 7px;*/
        /*    color: #2c536c;*/
        /*}*/
        /*.dws-input:nth-child(2)::before{*/
        /*    content: "\f023";*/
        /*}*/
        /*.dws-input:hover::before{*/
        /*    color: #319ebc;*/
        /*    transition: all 0.3s;*/
        /*}*/

        h1, table {
            font-family: "Helvetica", fantasy;
        }

    </style>
</head>
<body>
<div class="container">
<h1>Панель администратора <span title="1. Значение суммы займа должно быть кратно 100. Минимальное допустимое
значение 500, максимальное 100 000. Мин. сумма займа должна быть меньше
макс. сумме займа
2. Длительность займа задается в месяцах. Минимальное значение 1 мес.,
максимальное 36 мес. Мин. сумма займа должна быть меньше макс. суммы
займа.
3. Годовая ставка задается в %. Минимальное значение 3%, максимальное 150%">&#63;</span> </h1>
    <% Data data = request.getAttribute("data") != null ? (Data) request.getAttribute("data") : null; %>

    <% if (data != null) {
        for (String erorrMessage : data.getErrorMessages())  { %>
    <p style="color: red">
        <%= "" + erorrMessage %>
    </p>

    <% }
    } %>

    <form action="admin" method="post">
        <table>
            <tr><td><div class="dws-input"><input type="text" name = "minSum" placeholder="Мин. сумма займа"/></div></td></tr>
            <tr><td><div class="dws-input"><input type="text" name = "maxSum" placeholder="Макс. сумма займа"/></div></td></tr>
            <tr><td><div class="dws-input"><input type="text" name = "minMonth" placeholder="Мин. длит-ть займа"/></div></td></tr>
            <tr><td><div class="dws-input"><input type="text" name = "maxMonth" placeholder="Макс. длит-ть займа"/></div></td></tr>
            <tr><td><div class="dws-input"><input type="text" name = "intRate" placeholder="Годовая % ставка"/></div></td></tr>
            <tr><td><input type="submit" value="Применить" class="dws-submit" ></td></tr>
        </table>
    </form>
</div>
</body>
</html>
