<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP测试</title>
	<style type="text/css">
		body{background-color:#00EEEE;}
		p{font-size:35px;margin-top:50px;margin-bottom:30px;}
		.b2{margin-left:40px;width:180px;height:40px;margin-top:30px;}
		table{width:800px; margin-top:20px;}
	</style>
</head>
<body>
	<jsp:useBean id="User" class="caoyizhe.JavaBean" scope="page"> 
	</jsp:useBean>
	<%  
	    String sql = "SELECT * FROM `user`";  
	    ResultSet rs = User.select(sql);  
	%>
	
	<center><p>项目管理系统</p>
	<form action="Search_done.jsp" method="post">
		<span>欲查询的user_id：<input type="text" name="user_id"/>	
		<input name="sbt" type="submit" value="查询">
		</span>
	</form>
	<button class="b2" onClick="window.location='insert.jsp'">增加user</button>
	</center>
	
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