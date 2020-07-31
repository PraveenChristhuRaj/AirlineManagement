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
</head>
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
.home
{
border-radius:10px;
border:1px solid white;
padding:10px;
}
</style>
<body>
<div style="background-color:#ffcccc;border-radius:20px;padding:5px">
<h1 style="text-align:center;font-family:Sofia;font-size:40px">Airline Management
<i class='fas fa-plane-departure' style="font-size:40px"></i>
</h1>
<div style="width:5%;float:right"><input type="button" class="home" value="Home" style="cursor:pointer" onclick="window.location.href='homePage';return false;"/>
</div>
<div style="text-align:left;margin-left:10px;font-size:30px;font-family:Sofia"> Welcome ${sessionScope.username } <i class='fas fa-user-circle'></i></div>

</div>
<div><h3 style="font-family:Sofia">Booked flight / Pending status</h3></div>
<div style="background-color:#ffe6e6">
<table>
<tr>
<th>Name</th>
<th>Flight Id</th>
<th>Flight Number</th>
<th>Origin</th>
<th>Destination</th>
<th>Flight Time</th>
<th>Status</th>
</tr>
<c:forEach var="tempBooking" items="${bookingRecord }">
<tr>
 <c:url var="seatConfirm" value="/seatConfirm">
   <c:param name="bookingId" value="${tempBooking.bookingId }"/>
</c:url>    
<c:if test=
<td>${tempBooking.user.userName}</td>
<td>${tempBooking.flight.id}</td>
<td>${tempBooking.flight.flightNumber}</td>
<td>${tempBooking.flight.origin }</td>
<td>${tempBooking.flight.destination }</td>
<td>${tempBooking.flight.flightTime }</td>
<td>${tempBooking.status }</td>
<c:if test="${tempBooking.status=='Pending' }">
<td><input type="button" value="Click here to confirm Seat" class="textbox" style="width:150%;padding:8px;background-color:#ffcccc;cursor:pointer" onclick="window.location.href='${seatConfirm }'">
</td> 
</c:if> 

</tr>
</c:forEach>
</table>
</div>
</body>
</html>