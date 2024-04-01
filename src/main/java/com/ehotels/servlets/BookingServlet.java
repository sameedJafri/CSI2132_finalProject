package com.ehotels.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userId = request.getParameter("user_id");
        String roomId = request.getParameter("room_id");
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");

        String insertQuery = "INSERT INTO Bookings (user_id, room_id, start_date, end_date) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/e_hotels", "user", "password");
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            
            statement.setString(1, userId);
            statement.setString(2, roomId);
            statement.setString(3, startDate);
            statement.setString(4, endDate);

            int result = statement.executeUpdate();
            if (result > 0) {
                // Booking successful
            } else {
                // Booking failed
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
