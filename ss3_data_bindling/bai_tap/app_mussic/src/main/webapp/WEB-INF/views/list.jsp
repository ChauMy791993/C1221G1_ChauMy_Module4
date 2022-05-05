<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Song</title>
</head>
<body>
<h2>List Song</h2>
<c:forEach items="${songList}" var="song">
<p>Song name : ${song.nameSong}</p>
    <p>Singer Name : ${song.singerName}</p>
    <p>Type Music : ${song.typeMusic}</p>
    <p>File Music : ${song.fileMusic}</p>
    <hr>
</c:forEach>
<button><a href="/settings">Back Settings</a></button>
</body>
</html>
