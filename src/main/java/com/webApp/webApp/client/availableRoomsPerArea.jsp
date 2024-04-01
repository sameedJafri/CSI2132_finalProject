<%@ page import="java.util.List" %>
<%@ page import="com.ehotels.model.AvailableRoom" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Rooms Per Area</title>
</head>
<body>
<h1>Available Rooms Per Area</h1>
<table border="1">
    <tr>
        <th>Area</th>
        <th>Available Rooms</th>
    </tr>
    <%
        List<AvailableRoom> availableRoomsList = (List<AvailableRoom>) request.getAttribute("availableRoomsList");
        for (AvailableRoom room : availableRoomsList) {
    %>
    <tr>
        <td><%= room.getArea() %></td>
        <td><%= room.getAvailableRooms() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
