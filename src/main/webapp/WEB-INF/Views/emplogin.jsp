<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>Login</legend>
<form action="./emplogin" method="post">
<table>
<tr style="font-style:italic;">
<td>Employee Id</td>
<td>:</td>
<td><input type="text" name="id"></td></tr>
<tr style="font-style:italic;">
<td>Password</td>
<td>:</td>
<td><input type="password" name="pwd"></td></tr>
<tr>
<td><input type="submit" value="login"></td></tr>
</table></form></fieldset>
</body>
</html>