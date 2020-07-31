<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table,tr,th,td
{
padding:10px;
font-family:Sofia;
}
.textbox
{
border-radius:10px;
border:1px solid white;
padding:10px;
font-family:Sofia;
background-color:#ffcccc;
}

</style>
</head>
<body>
<div style="background-color:#ffcccc;border-radius:20px;padding:5px">
<h1 style="text-align:center;font-family:Sofia;font-size:40px">Airline Management
<i class='fas fa-plane-departure' style="font-size:40px"></i>
</h1>
</div>
<div>
<h3 style="font-size:20px">Only Registered users can book a flight    <i class='far fa-hand-point-right' style='font-size:30px'></i>
<input type="button" class="textbox" value="Click here for Registration" onclick="window.location.href='showUserForm';return false;"/>
</h3>

</div>
<div style="background-color:#ffe6e6;width:80%;margin-top:50px;margin-left:10px;">
<table>
<tr>
<th>FlightId</th>
<th>FlightNumber</th>
<th>Origin</th>
<th>Destination</th>
<th>Flight Date</th>
<th>Flight time</th>
<th>Airline</th>
<th>No of seats</th>
</tr>
<c:forEach var="tempFlight" items="${flight }">

<tr>
<td>${tempFlight.id }</td>
<td>${tempFlight.flightNumber }</td>
<td>${tempFlight.origin }</td>
<td>${tempFlight.destination }</td>
<td>${tempFlight.flightDate }</td>
<td>${tempFlight.flightTime }</td>
<td>${tempFlight.flightInfo.airlineInfo.nameOfAirline }</td>
<td>${tempFlight.inventory.count }
</tr>

</c:forEach>
</table>
</div>
</body>
</html>