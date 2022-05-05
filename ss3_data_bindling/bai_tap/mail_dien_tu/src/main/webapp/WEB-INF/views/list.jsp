<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Email</title>
</head>
<body>
<h2>List email</h2>
<c:forEach items="${emailList}" var="email">
    <p>language : ${email.languages}</p>
    <p>Page Size : ${email.pageSize}</p>
    <p>Spam Filter : ${email.spamFilter}</p>
    <p>signature: ${email.signature}</p>
    <hr>
</c:forEach>
<button><a href="/settings">Back Settings</a></button>
</body>
</html>
