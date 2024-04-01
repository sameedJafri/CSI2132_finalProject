<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Rooms</title>
</head>
<body>
    <h2>Search for Available Rooms</h2>
    <form action="searchRooms" method="get"> <!-- This action should match the URL pattern defined for RoomSearchServlet in web.xml -->
        Start Date: <input type="date" name="start" required><br>
        End Date: <input type="date" name="end" required><br>
        Capacity: <input type="number" name="capacity" min="1" required><br>
        <!-- Add more input fields as needed based on your criteria -->
        <input type="submit" value="Search">
    </form>
</body>
</html>
