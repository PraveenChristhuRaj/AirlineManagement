<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
.textbox
{
border-radius:10px;
border:1px solid white;
}
table,tr,td,th
{
padding:10px;
font-size:20px;
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
<div class="wrapper" style="width:40%;border:1px solid black;margin-left:50px;float:left;border-radius:10px;margin-top:50px;background-color:#ffe6e6">
<h3 style="text-align:center;font-family:Sofia;font-size:30px">User Registration</h3>

<form:form action="processUserForm" method="post" modelAttribute="user">
<table>
<tr>
<td>FirstName</td>
<td><form:input path="firstName" cssClass="textbox"/></td>
</tr>
<tr>
<td>LastName</td>
<td><form:input path="lastName" cssClass="textbox"/></td>
<tr>
<tr>
<td>UserName</td>
<td><form:input path="userName" cssClass="textbox"/></td>
</tr>
<tr>
<td>Password</td>
<td><form:input path="password" type="password" cssClass="textbox"/>
</tr>
<tr>
<td>Gender</td>
<td>
<form:radiobutton path="gender" label="Male" value="Male"/>
<form:radiobutton path="gender" label="Female" value="Female"/>
</td>
</tr>
<tr>
<td>MobileNumber</td>
<td><form:input path="mobileNumber" cssClass="textbox"/>
</tr>
<tr>
<td><input type="submit" value="Register" style="width:150%;padding:8px;align:left;" class="textbox"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>