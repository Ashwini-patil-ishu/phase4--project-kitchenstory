<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.head{
	font-family: Garamond;
	font-size:30px;
	color: green;
	padding:1px;
	max-width:500px;
	padding-top: 100px;
}
.active{
	display :block;
	text-decoration: none;
	float: right;
	padding: 1%;
	margin: auto;
	margin-right : 1%;
	margin-left : 1%;
	font-size: 22px;
	font-family: Garamond;
	color: green;
}
.active a:hover {
	background: gray;
}
</style>
</head>
<body>
<br><br>
<a class="active" href="foodlist.jsp"><b>Admin Food Details</b></a>
<a class="active" href="user-list.jsp"><b>USER LIST</b></a>
<a class="active" href="adminlogin.jsp"><b>LOGIN</b></a>
<a class="active" href="HOME_SCREEN.jsp"><b>HOME</b></a><br><br>
<h1>Admin Registerd Sucessfully</h1>

</body>
</html>