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
        <th hidden>isExceed</th>
        <th width="100">Описание</th>
        <th width="100">Калории</th>
        <th width="160">Дата, время</th>
    </tr>
    <c:forEach items="${mealsWithExceeded}" var="meals">
        <tr bgcolor="${meals.isExceed() ? "#ffb6c1" : "#00ff7f"}">
            <td hidden>${meals.isExceed()}</td>
            <td>${meals.getDescription()}</td>
            <td>${meals.getCalories()}</td>
            <td>${meals.getDateTimeWithoutT()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

