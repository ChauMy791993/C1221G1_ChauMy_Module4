<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2><a href="/settings">Settings</a></h2>
<form:form action="update" modelAttribute="email" method="post">
    <div>
        <span>Languages</span>
        <form:select path="languages">
            <option value="english">English</option>
            <option value="vietnamese">Vietnamese</option>
            <option value="japanese">Japanese</option>
            <option value="chinese">Chinese</option>
        </form:select>
    </div>
    <div>
        <label>Page size</label>
        <span>Show</span>
        <form:select path="pageSize">
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
            <span>emails per page</span>
        </form:select>
    </div>
    <div>
        <label>Spam filter :</label>
        <form:checkbox path="spamFilter"/> enable spam filter
    </div>
    <div>
            <span>Signature</span>
        <form:textarea id="signature" path="signature"/>
    </div>
    <div>
        <input type="submit" value="update">
        <input type="reset" value="cancel">
    </div>
</form:form>
<h2 style="color: green">${message}</h2>
<button><a href="/list">Show List Email</a></button>
</body>
</html>
