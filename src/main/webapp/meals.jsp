<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>

<table border="1">
    <tr bgcolor="#a9a9a9">
        <td width="60">ID</td>
        <th width="100">Описание</th>
        <th width="100">Калории</th>
        <th width="160">Дата, время</th>

    </tr>
    <c:forEach items="${mealsWithExceeded}" var="meals">
        <tr bgcolor="${meals.isExceed() ? "#ffb6c1" : "#00ff7f"}">
            <td>${meals.getId()}</td>
            <td>${meals.getDescription()}</td>
            <td>${meals.getCalories()}</td>
            <td>${meals.getDateTimeWithoutT()}</td>

        </tr>
    </c:forEach>
</table>
<br>

<h3>Add a meal</h3>

<form method="post">
    ID : <input type="text" name="id">
    Description : <input type="text" name="description">
    Calories : <input type="text" name="calories">
    DateTime : <input type="datetime-local" name="datetime">
    <input type="submit">
</form>

</table>
</body>
</html>

