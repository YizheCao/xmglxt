<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%> 
<jsp:useBean id="User" class="caoyizhe.JavaBean" scope="page"> 
</jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");  
	int user_id = Integer.parseInt(request.getParameter("user_id")); 
	
	String sql = "SELECT * FROM user WHERE user_id=" + user_id;  
	ResultSet rs = User.select(sql); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询结果界面</title>
	<style type="text/css">
		body{background-color:#00EEEE;}
		table{width:800px; margin-top:200px;}
	</style>
</head>
<body>
	<center>
	<table border="1"; height="82";>  
        <tr height=60px>  
            <td width=15%>user_id</td>  
            <td width=20%>user_no</td>  
            <td width=20%>user_name</td>  
            <td width=25%>user_password</td>
            <td width=10%></td> 
            <td width=10%></td>   
        </tr>  
        <%  
            while(rs.next()) {  
                out.print("<tr height=60px>");  
                out.print("<td>" + rs.getInt("user_id") + "</td>");  
                out.print("<td>" + rs.getString("user_no") + "</td>");  
                out.print("<td>" + rs.getString("user_name") + "</td>");  
                out.print("<td>" + rs.getString("user_password") + "</td>"); 
                out.print("<td><a href='delete.jsp?user_id=" + rs.getInt("user_id") + "'>删除</a></td>"); 
                out.print("<td><a href='update.jsp?user_id=" + rs.getInt("user_id") + "'>修改</a></td>"); 
                out.print("</tr>");  
            }  
            if (rs != null) {  
                rs.close();  
            }  
        %>  
    </table>
    </center>
</body>
</html>