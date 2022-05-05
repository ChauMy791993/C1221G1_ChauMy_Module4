<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song Upload</title>
</head>
<body>
<h1 style="color: green">${message}</h1>
<form:form modelAttribute="song" method="post" action="save">
    <div>
        <label>Name song:</label>
        <form:input type="text" path="nameSong"/>
    </div>
    <div>
        <label>Name singer:</label>
        <form:input type="text" path="singerName"/>
    </div>
    <div>
        <label>Type Music:</label>
        <form:select path="typeMusic">
            <option value="pop">Pop</option>
            <option value="rock">Rock</option>
            <option value="jazz">jazz</option>
            <option value="rap">Rap</option>
        </form:select>
    </div>
    <div>
       <label>File Music:</label>
        <form:input type="text" path="fileMusic"/>
    </div>
    <div>
        <input type="submit" value="update">
        <input type="reset" value="cancel">
    </div>
</form:form>
<h3 style="color: green">${message}</h3>
<button><a href="/list">List Song</a></button>
</body>
</html>
