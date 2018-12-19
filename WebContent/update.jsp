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
	if(rs.next()){
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>更新界面</title>
	<style type="text/css">
		body{
			background-color:#00EEEE;
		}
		form{
			width:600px; 
			margin-top:100px; 
			margin-left:400px;
		}
		.id{
			width:500px;
			height:60px;
			<!设置圆形边框>
			border-radius:25px;
			border-style:outset;
			border-color:gray;
			border-width:5px;
		}
		.id .txt{
			margin-top:15px;
			width:300px;
			height:20px;
		}
		.sbt .btn{
			width:460px;
			height:70px;
			font-size:25px;
			background-color:red;
			margin-left:25px;
		}
	</style>
</head>
<body>
	<form action="Update_done.jsp" method="post">
		<div class="id">
			<label style="font-size:20px">user_id：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
			<input class="txt" type="text" name="user_id" value="<% out.print(user_id); %>"/>
		</div>
		<br/>

		<div class="id">
			<label style="font-size:20px">user_no：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
			<input class="txt" type="text" name="user_no" value="<% out.print(rs.getString("user_no")); %>"/>
		</div>
		<br/>

		<div class="id">
			<label style="font-size:20px">user_name：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
			<input class="txt" type="text" name="user_name" value="<% out.print(rs.getString("user_name")); %>"/>
		</div>
		<br/>
		
		<div class="id">
			<label style="font-size:20px">user_password：</label>
			<input class="txt" type="password" name="user_password" value="<% out.print(rs.getString("user_password")); %>"/>
		</div>
		<br/>
		
		<div class="sbt">
			<button class="btn" type="submit"><b>确&nbsp&nbsp&nbsp认&nbsp&nbsp&nbsp更&nbsp&nbsp&nbsp新<b/></button>
		</div>
	</form>
	<% } %>
</body>
</html>