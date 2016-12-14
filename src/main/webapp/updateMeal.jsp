<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Update meal</title>
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

<h3>Изменить</h3>

<form method="post" action='meals'>
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr hidden>
            <td align="right" width="100">ID</td>
            <td><input type="text" name="id" value="${mealId}" readonly="readonly"></td>
        </tr>
        <tr>
            <td align="right" width="100">Description</td>
            <td><input type="text" name="description" autofocus></td>
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

</body>
</html>