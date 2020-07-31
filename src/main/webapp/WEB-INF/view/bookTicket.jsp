<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style>
table,tr,th,td
{
padding:10px;
font-family:Sofia;
font-size:20px;
}
.textbox
{
border-radius:10px;
border:1px solid white;
padding:10px;
background-color:#ffcccc;
}
.home
{
border-radius:10px;
border:1px solid white;
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
<div style="width:5%;float:right"><input type="button" class="home" value="Home" style="cursor:pointer" onclick="window.location.href='homePage';return false;"/>
</div>
<div style="text-align:left;margin-left:10px;font-size:30px;font-family:Sofia"> Welcome ${sessionScope.username } <i class='fas fa-user-circle'></i></div>
</div>
<div style="margin-left:20px">
<h3>Flight Information</h3>
<form:form action="ticketBook" method="post" modelAttribute="bookingRecord">
<table>
<tr>
<td>Flight Number</td>
<td><form:input readonly="true" path="flightNumber" value="${flight.flightNumber }" cssClass="textbox"/></td>
</tr>
<tr>
<td>Flight Date</td>
<td><input type="text" readonly name="date" value="${flight.flightDate }" class="textbox"/></td>
</tr>
<tr>
<td>Origin</td>
<td><form:input readonly="true" path="origin" value="${flight.origin }" cssClass="textbox"/>
</tr>
<tr>
<td>Destination</td>
<td><form:input readonly="true" path="destination" value="${flight.destination }" cssClass="textbox"/>
</tr>
<tr>
<tr>
<td>Flight Time</td>
<td><input type="text" readonly name="time" value="${flight.flightTime }" class="textbox"/>
</tr>
<tr>
<td>Fare</td>
<td><form:input path="fare" readonly="true" value="${flight.fare.fare }" cssClass="textbox"/>
</tr>
<tr>
<td>Flight Id</td>
<td><input type="text" readonly name="flightId" value="${flight.id }" class="textbox"/></td>
</tr>
<tr>
<tr>
<td><input type="submit" value="Proceed for booking" class="textbox" style="cursor:pointer"></td>
</tr>
</table>
</form:form>
</div>
</body>
</html>