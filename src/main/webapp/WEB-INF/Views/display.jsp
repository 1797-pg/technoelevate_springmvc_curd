<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <% String msg=(String)request.getAttribute("errmsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <% 
   if(msg!=""&&!msg.isEmpty()){
	   %>
	   
	   <%=msg%>
	   <%
	   
	   }
	   %>
</body>
</html>