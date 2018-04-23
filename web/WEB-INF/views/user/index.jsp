<%--
  Created by IntelliJ IDEA.
  User: Weidro
  Date: 2018/4/23
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>用户管理</title>
</head>
<body>
<h2>
    用户管理
</h2>
<table width="100%" border="1">
    <tr>
        <th>编号</th><th>姓名</th><th>地址</th><th>电话</th>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td><td>${user.name}</td><td>${user.address}</td><td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>