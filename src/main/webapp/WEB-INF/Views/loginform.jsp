<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<fieldset>
<legend>Login</legend>
<form action="./login3" method="post">
<table>
<tr style="font-style:italic;">
<td>Username</td>
<td>:</td>
<td><input type="text" name="user"></td></tr>
<tr style="font-style:italic;">
<td>Password</td>
<td>:</td>
<td><input type="password" name="pass"></td></tr>
<tr>
<td><input type="submit" value="login"></td></tr>
</table></form></fieldset>
</body>
</html>