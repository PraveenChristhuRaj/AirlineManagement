<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
table,tr,th,td
{
padding:10px;
font-size:20px;
}
.textbox
{
border-radius:10px;
border:1px solid white;
padding:10px;

}
.book
{
border-radius:10px;
border:1px solid white;
}
.registration
{
padding:10px;

font-size:15px;
float:right;
}

</style>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:#ffcccc;border-radius:20px;padding:5px">
<h1 style="text-align:center;font-family:Sofia;font-size:40px">Airline Management
<i class='fas fa-plane-departure' style="font-size:40px"></i>
</h1>
<div style="width:5%;float:right"><input type="button" class="textbox registration" value="Logout" style="cursor:pointer" onclick="window.location.href='applicationLogout';return false;"/>
</div>
<div style="width:20%;float:right"><input type="button" class="textbox registration" value="Booked and Pending flight booking" style="cursor:pointer" onclick="window.location.href='pendingBooking';return false;"/>
</div>
<div style="text-align:left;margin-left:20px;font-size:30px;font-family:Sofia;width:20%"> Welcome ${sessionScope.username } <i class='fas fa-user-circle'></i></div>
</div>
<div style="background-color:#ffe6e6;width:70%;margin-top:50px;margin-left:10px;">
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
<c:forEach var="tempFlight" items="${flight}">
<c:url var="bookTicket" value="/bookTicket">
   <c:param name="flightId" value="${tempFlight.id }"/>
</c:url>
<tr>
<td>${tempFlight.id }</td>
<td>${tempFlight.flightNumber }</td>
<td>${tempFlight.origin }</td>
<td>${tempFlight.destination }</td>
<td>${tempFlight.flightDate }</td>
<td>${tempFlight.flightTime }</td>
<td>${tempFlight.flightInfo.airlineInfo.nameOfAirline }</td>
<td>${tempFlight.inventory.count }
<td><input type="button" value="Book Ticket" style="cursor:pointer" class="book registration" onclick="window.location.href='${bookTicket }' "></td>
</tr>

</c:forEach>
</table>
</div>
<div style="">Pending booking</div>
</body>
</html>