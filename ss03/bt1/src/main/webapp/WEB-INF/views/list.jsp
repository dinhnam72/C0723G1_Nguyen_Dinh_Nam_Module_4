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
<p style="color: green">${mess}</p>
<h1>Email List</h1>
<table>
    <thead>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Function</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${emailBoxList}" var="email">
        <tr>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td><a href="email/update/${email.id}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
