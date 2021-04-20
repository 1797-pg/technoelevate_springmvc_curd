<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String)request.getAttribute("msg");%>
    <%String errmsg=(String)request.getAttribute("errmsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>

<form action="./addEmployee">
<label id="name">Name</label>
<input type="text" name="name">
<label>Id</label>
<input type="text" name="Id">
<label>BirthDate</label>
<input type="text" name="dob">
<br>
<input type="submit" value="Add Details">
</form>
</fieldset>

<% if(msg!=null&&!msg.isEmpty()){ %>
<h1><%=msg %></h1>
<%} %>



</body>
</html>