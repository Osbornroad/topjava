<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Meal list</title>
    <style>
        #table{
            border-collapse: collapse;
        }
        #tr{
            border-bottom:1px solid black;
            border-top:1px solid black;

        }
        #td{
            text-align: center;
        }
    </style>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Список еды</h2>

<a href="meals?action=filling">Загрузить тестовые данные</a>
<br/>
<br/>
<table id = table>
    <tr id = tr bgcolor="#00bfff">
        <th height="40" width="60">Номер</th>
        <th width="100">Описание</th>
        <th width="100">Калории</th>
        <th width="160">Дата, время</th>
        <th width="120">Удалить</th>
        <th width="120">Изменить</th>
    </tr>
    <c:forEach items="${mealsWithExceeded}" var="meals">
        <tr id = tr bgcolor="${meals.isExceed() ? "#ffb6c1" : "#00ff7f"}" align="center">
            <td height="30">${meals.getId()}</td>
            <td>${meals.getDescription()}</td>
            <td>${meals.getCalories()}</td>
            <td>${meals.getDateTimeWithoutT()}</td>
            <td><a href="meals?action=delete&mealId=<c:out value="${meals.getId()}"/>">Удалить</a></td>
            <td><a href="meals?action=update&mealId=<c:out value="${meals.getId()}"/>">Изменить</a></td>
        </tr>
    </c:forEach>
</table>
<br>

<h3>Добавить</h3>

<form method="post" >
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td align="right" width="100">ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td align="right" width="100">Description</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td align="right" width="100">Calories</td>
            <td><input type="text" name="calories"></td>
        </tr>
        <tr>
            <td align="right" width="100">DateTime</td>
            <td><input type="datetime-local" name="datetime"></td>
        </tr>
        <tr>
            <td align="right" width="100"></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>

<h3>Изменить</h3>

<form method="post">
    ID : <input type="text" name="id" value="${newMeal.getId()}" readonly="readonly">
    Description : <input type="text" name="description">
    Calories : <input type="text" name="calories">
    DateTime : <input type="datetime-local" name="datetime">
    <input type="submit">
</form>

</table>
</body>
</html>

