package com.ehotels.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String query = "SELECT * FROM Users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/e_hotels", "user", "password");
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Login success
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                // Redirect or forward to success page
            } else {
                // Login failure
                // Redirect or forward to failure page
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
