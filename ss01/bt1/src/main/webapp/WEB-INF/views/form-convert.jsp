<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/14/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chuyển đổi tiền tệ</h1>
<form action="/convert" method="post">
    <p>Tỉ giá: 23000</p>
    <label for="usd">USD</label>
    <input id="usd" name="usd" type="number" value="${usd}"><br>
    <button>Chuyển đổi</button>
</form>
    VNĐ: <span style="color: red">${result}</span>
</body>
</html>
