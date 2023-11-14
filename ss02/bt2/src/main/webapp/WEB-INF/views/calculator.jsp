<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/14/2023
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <label for="number1"> Number1</label>
    <input type="number" id="number1" name="number1" value="${number1}"><br>
    <label for="number2"> Number2</label>
    <input type="number" id="number2" name="number2" value="${number2}"><br>
    <button type="submit" name="calculation" value="+">Addition(+)</button>
    <button type="submit" name="calculation" value="-">Subtraction(-)</button>
    <button type="submit" name="calculation" value="*">Multiplication(X)</button>
    <button type="submit" name="calculation" value="/">Division(/)</button>
</form>
<c:choose>
    <c:when test="${error!=null}">
        <p style="color: red">${error}</p>
    </c:when>
    <c:otherwise>
        <p>Kết quả: ${result}</p>
    </c:otherwise>

</c:choose>
</body>
</html>
