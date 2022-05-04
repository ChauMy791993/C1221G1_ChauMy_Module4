<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/4/2022
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<form action="/converter" method="post">
    <div>
        <input type="number" name="usd" placeholder="USD">
    </div>
    <hr>
    <div>
        <input type="submit" value="converter">
    </div>
</form>
<c:if test="${result != null}">
    <h2> Result : ${result}</h2>
</c:if>
</body>
</html>
