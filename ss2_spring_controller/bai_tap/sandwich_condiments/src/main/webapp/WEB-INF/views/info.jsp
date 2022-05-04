<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich condiments</h2>
    <c:forEach var="condiment" items="${condimentList}">
        <p>${condiment}</p>
    </c:forEach>
</body>
</html>
