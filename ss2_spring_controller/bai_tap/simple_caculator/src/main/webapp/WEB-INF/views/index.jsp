<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Caculator</title>
  </head>
  <body>
  <a href="/"><h2>Calculator</h2></a>
    <form action="/save" method="post">
    <div>
      <input type="number" name="number1" placeholder="number 1">
      <input type="number" name="number2" placeholder="number 2">
    </div>
      <br>
    <div>
      <button type="submit" name="operator" value="+">Addition(+)</button>
      <button type="submit" name="operator" value="-">Subtraction(-)</button>
      <button type="submit" name="operator" value="*">Multiplication(x)</button>
      <button type="submit" name="operator" value="/">Division(/)</button>
    </div>
  </form>
<hr>
  <c:if test="${result != null}">
    Result : ${result}
  </c:if>

  </body>
</html>
