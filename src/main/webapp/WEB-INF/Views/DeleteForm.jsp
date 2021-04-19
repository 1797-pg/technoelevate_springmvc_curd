<%@page import="com.te.springmvc.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg=(String) request.getAttribute("msg"); 
    EmployeeBean bean=(EmployeeBean)request.getAttribute("data");%>
    <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<form action="./delete2">
<label>Empolyee id:</label>
<input type="text" name="id" required><br><br>
<input type="submit" value="delete">
</form>
</fieldset>

<%if(bean!=null) {%>
<h4>Name: <%=bean.getName() %></h4>
<h4>ID:<%=bean.getId() %></h4>

<% }%>
</body>
</html>