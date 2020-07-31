<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<style>
.textbox
{
border-radius:10px;
border:1px solid white;
}
.registration
{
padding:10px;
font-family:Sofia;
background-color:#ffcccc;
}
.logout
{
padding:10px;
font-family:Sofia;
background-color:#ffcccc;
}
table,tr,td,th
{
padding:10px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:#ffcccc;border-radius:20px;padding:5px">
<h1 style="text-align:center;font-family:Sofia;font-size:40px">Airline Management
<i class='fas fa-plane-departure' style="font-size:40px"></i>
</h1>
</div>
<div>
<h3 style="font-size:20px">Only Registered users can book a flight    <i class='far fa-hand-point-right' style='font-size:30px'></i>
<input type="button" class="textbox registration" style="cursor:pointer" value="Click here for Registration" onclick="window.location.href='showUserForm';return false;"/>
</h3>
</div>
<div class="wrapper" style="width:20%;border:1px solid black;margin-left:15%;float:left;border-radius:10px;margin-top:50px;background-color:#ffe6e6">
<form:form action="validateLogin" method="post" modelAttribute="user">
<h3 style="text-align:center;font-family:Sofia;font-size:30px;">User Login</h3>
<table style="padding:10px">
<tr>
<td>UserName</td>
<td><form:input path="userName" cssClass="textbox"/></td>
<tr>
<tr>
<td>Password</td>
<td><form:input path="password" type="password" cssClass="textbox"/></td>
</tr>
<tr>
<td><input type="submit" value="Login" class="textbox" style="cursor:pointer;width:150%;padding:8px;"></td>
</tr>
<tr>

</tr>
</table>
</form:form>
</div>
<div style="width:20%;border:1px solid black;margin-right:15%;float:right;border-radius:10px;margin-top:50px;background-color:#ffe6e6">
<h3 style="text-align:center;font-family:Sofia;font-size:30px;">Search Flights</h3>
<form:form action="fetchFlights" method="get" modelAttribute="flight">
<table>
<tr>
<td>Origin</td>
<td><form:input path="origin" cssClass="textbox"/>
</tr>
<tr>
<td>Destination</td>
<td><form:input path="destination" cssClass="textbox"/>
</tr>
<tr>
<td>Date</td>
<td><input type="text" name="date" class="textbox"/>
</tr>
<tr>
<td><input type="submit" value="Search" class="textbox" style="cursor:pointer;width:150%;padding:8px;align:left;"></td>
</tr>
<tr>
</tr>
</table>
</form:form>
</div>
</body>
</html>