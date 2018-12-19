<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<jsp:useBean id="User" class="caoyizhe.JavaBean" scope="page"> 
</jsp:useBean>
<%  
	request.setCharacterEncoding("UTF-8");  
	int user_id = Integer.parseInt(request.getParameter("user_id"));  
	String user_no = request.getParameter("user_no");  
	String user_name = request.getParameter("user_name");
	String user_password = request.getParameter("user_password");  
	String sql1 = "select 1 from user where user_id = " + user_id;  
	ResultSet rs = User.select(sql1);  
	if(!rs.next()){  
		String sql_insert = "insert user values (" + user_id + ",'" + user_no + "','" + user_name + "','" + user_password + "')";  
		User.insert(sql_insert);  
		out.print("<script>alert('添加成功！'); window.location='caoyizhe.jsp' </script>");
	}else  {
		out.print("<script>alert('添加失败！'); window.location='insert.jsp' </script>");	
	}  
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>插入过程</title>
</head>
<body>
	
</body>
</html>