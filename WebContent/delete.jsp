<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<jsp:useBean id="User" class="caoyizhe.JavaBean" scope="page"> 
</jsp:useBean>
<%  
	request.setCharacterEncoding("UTF-8");  
	int user_id = Integer.parseInt(request.getParameter("user_id"));  
	System.out.println(user_id);
	String sql_delete = "delete from user where user_id= " + user_id;  
	User.delete(sql_delete);  
	out.print("<script>alert('删除成功！'); window.location='caoyizhe.jsp' </script>");
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>删除过程</title>
</head>
<body>

</body>
</html>