package com.ehotels.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class RoomSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String startDate = request.getParameter("start");
        String endDate = request.getParameter("end");
        String capacity = request.getParameter("capacity");
        // Additional criteria can be added based on project requirements.

        String query = "SELECT * FROM Rooms WHERE capacity = ? AND id NOT IN (SELECT room_id FROM Bookings WHERE start_date <= ? AND end_date >= ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/webApp/e_hotels", "user", "password");
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, capacity);
            statement.setString(2, endDate);
            statement.setString(3, startDate);

            ResultSet results = statement.executeQuery();
            while (results.next()) {
                // Process and display results, or forward to a JSP page
            }
            
            // Forward to a JSP page or dynamically write HTML for display.
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions, maybe forward to an error page.
        }
    }
}
