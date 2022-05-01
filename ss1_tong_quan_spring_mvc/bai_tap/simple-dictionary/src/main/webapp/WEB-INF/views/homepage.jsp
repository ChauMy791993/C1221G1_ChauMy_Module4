<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/translate" method="post">
    <h3>Simple Dictionary</h3>
    <input type="text" name="word" placeholder="enter world">
    <input type="submit" value="Enter">
</form>
<hr>
<h2>
    Result : ${result}
</h2>

</body>
</html>
