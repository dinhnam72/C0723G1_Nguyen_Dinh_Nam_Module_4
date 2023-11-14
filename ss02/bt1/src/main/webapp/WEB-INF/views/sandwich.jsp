<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/14/2023
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiment</h1>
<form action="/save" method="post">
    <input type="checkbox" id="condiment1" name="condiment" value="Lettuce">
    <label for="condiment1"> Lettuce</label>
    <input type="checkbox" id="condiment2" name="condiment" value="Tomato">
    <label for="condiment2"> Tomato</label>
    <input type="checkbox" id="condiment3" name="condiment" value="Mustard">
    <label for="condiment3"> Mustard</label>
    <input type="checkbox" id="condiment4" name="condiment" value="Sprouts">
    <label for="condiment4"> Sprouts</label><br>
    <button>Save</button>
</form>
<p>Condiment :</p>
<c:forEach items="${condiment}" var="c">
    <p>${c}</p>
</c:forEach>
</body>
</html>
