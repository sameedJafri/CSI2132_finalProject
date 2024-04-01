<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.model.HotelCapacity" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel Capacities</title>
</head>
<body>
<h1>Hotel Capacities</h1>
<table border="1">
    <tr>
        <th>Hotel Name</th>
        <th>Total Capacity</th>
    </tr>
    <%
        List<HotelCapacity> hotelCapacityList = (List<HotelCapacity>) request.getAttribute("hotelCapacityList");
        for (HotelCapacity capacity : hotelCapacityList) {
    %>
    <tr>
        <td><%= capacity.getHotelName() %></td>
        <td><%= capacity.getTotalCapacity() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
