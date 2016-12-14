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

<table width="660">
    <tr>
        <td align="right">
            <a href="meals?action=filling">Загрузить тестовые данные</a>
        </td>
    </tr>
</table>

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
<br/>
<br/>
<form action="addMeal.jsp">
    <input type="submit" value="Добавить" />
</form>
<!--
<a href="addMeal.jsp">Добавить</a>

<h3>Изменить</h3>

<form method="post">
    ID : <input type="text" name="id" value="${newMeal.getId()}" readonly="readonly">
    Description : <input type="text" name="description">
    Calories : <input type="text" name="calories">
    DateTime : <input type="datetime-local" name="datetime">
    <input type="submit">
</form>
-->
</body>
</html>

