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
<title>Insert title here</title>a
</head>
<body>

 <%if(msg!=null&&msg.isEmpty()) {%>
 <h1> <%=msg%></h1>
 <% }%>

<fieldset>
<form action="./search2">
<label>Empolyee id:</label>
<input type="text" name="id" required><br><br>
<input type="submit" value="search">
</form>
</fieldset>

<%if(bean!=null) {%>
<h4>Name: <%=bean.getName() %></h4>
<h4>ID:<%=bean.getId() %></h4>

<% }%>
</body>
</html>