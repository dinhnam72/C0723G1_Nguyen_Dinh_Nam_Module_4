<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/16/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update</h1>
<form:form action="/email/update" modelAttribute="emailBox" method="post">
    <form:hidden path="id" ></form:hidden>
    <table>
        <tr>
            <td> Languages:</td>
            <td><form:select path="languages" items="${language}">
            </form:select></td>
        </tr>
        <tr>
            <td>Size page:</td>
            <td><form:select path="pageSize" items="${pageSize}">
            </form:select></td>
        </tr>
        <tr>
            <td>Spams Filter:</td>
            <td>Show <form:checkbox path="spamsFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:input path="signature"></form:input></td>
        </tr>
    </table>
    <form:button>Update</form:button>
</form:form>
</body>
</html>
