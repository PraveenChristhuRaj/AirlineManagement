<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
<div style="background-color:#ffcccc;border-radius:20px;padding:5px">
<h1 style="text-align:center;font-family:Sofia;font-size:40px">Airline Management
<i class='fas fa-plane-departure' style="font-size:40px"></i>
</h1>
<div style="text-align:left;margin-left:10px;font-size:30px;font-family:Sofia"> Welcome ${sessionScope.username } <i class='fas fa-user-circle'></i></div>

</div>
<div class="wrapper" style="width:90%;border:1px solid black;margin-left:50px;float:left;border-radius:10px;margin-top:50px;background-color:#ffe6e6">
<h3 style="text-align:center;font-family:Sofia;font-size:30px">Book a ticket</h3>

<form:form action="bookPassenger" method="post" modelAttribute="passenger">
<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Gender</th>
<th>MobileNumber</th>
</tr>
<tr>
<td><form:input path="firstName" cssClass="textbox"/></td>
<td><form:input path="lastName" cssClass="textbox"/></td>
<td><form:input path="emailAddress" cssClass="textbox"/></td>
<td>
<form:radiobutton path="gender" label="Male" value="Male"/>
<form:radiobutton path="gender" label="Female" value="Female"/>
</td>
<td><form:input path="mobileNumber" cssClass="textbox"/></td>
<td><input type="hidden" name="bookingId" value="${bookingRecord.bookingId }" class="textbox"/>
</td>
<td><input type="submit" value="Book Ticket" style="width:150%;padding:8px;align:left;cursor:pointer;background-color:#ffcccc" class="textbox"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>