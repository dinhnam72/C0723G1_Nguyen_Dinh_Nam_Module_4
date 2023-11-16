<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/14/2023
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Từ điển anh-việt</h1>
<form action="" method="post">
    <label for="keyWord">Tiếng anh</label>
    <input id="keyWord" name="keyWord" value="${keyWord}">
    <button>Tìm kiếm</button>
</form>
<p>Kết quả: ${result}</p>
</body>
</html>
