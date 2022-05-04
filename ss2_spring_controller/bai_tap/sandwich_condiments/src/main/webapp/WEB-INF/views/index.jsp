<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h2>Sandwich condiments</h2>
  <form action="/save">
    <input type="checkbox" id="condiments1" name="condiments" value="Lettuce">
    <label for="condiments1">Lettuce</label>
    <input type="checkbox" id="condiments2" name="condiments" value="Tomato">
    <label for="condiments2"> Tomato</label>
    <input type="checkbox" id="condiments3" name="condiments" value="Mustard">
    <label for="condiments3"> Mustard</label>
    <input type="checkbox" id="condiments4" name="condiments" value="Sprouts">
    <label for="condiments4"> Sprouts</label>
    <hr>
    <input type="submit" value="save">
  </form>
  </body>
</html>
