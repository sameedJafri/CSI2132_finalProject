<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Room</title>
</head>
<body>
    <h2>Book Your Room</h2>
    <form action="bookRoom" method="post"> <!-- This action should match the URL pattern for BookingServlet -->
        User ID: <input type="text" name="user_id" required><br>
        Room ID: <input type="text" name="room_id" required><br>
        Start Date: <input type="date" name="start" required><br>
        End Date: <input type="date" name="end" required><br>
        <input type="submit" value="Book">
    </form>
</body>
</html>
