<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h2>Meal list</h2>
    <a href="meals?action=create">Add Meal</a>
    <hr>

    <table>
        <tr>
            <td width="200">
                <form>
                    <table>
                        <tr>
                            <td>Start date</td>
                            <td>End date</td>
                        </tr>
                        <tr>
                            <td><input type="date" name="startDate" value="${fn:minDate()}"></td>
                            <td><input type="date" name="endDate" value="${fn:maxDate()}"></td>
                        </tr>
                    </table>
                    <button type="submit">Date filter</button>
                </form>
            </td>
            <td width="200">
                <form>
                    <table>
                        <tr>
                            <td>Start time</td>
                            <td>End time</td>
                        </tr>
                        <tr>
                            <td><input type="time" name="startTime"></td>
                            <td><input type="time" name="endTime"></td>
                        </tr>
                    </table>
                    <button type="submit">Time filter</button>
                </form>
            </td>
        </tr>
    </table>

    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>UserId</th>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>${meal.userId}</td>
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>


</body>
</html>