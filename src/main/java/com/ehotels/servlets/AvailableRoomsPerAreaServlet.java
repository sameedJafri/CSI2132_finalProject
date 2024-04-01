package com.ehotels.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ehotels.model.AvailableRoom;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvailableRoomsPerAreaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AvailableRoom> availableRoomsList = new ArrayList<>();
        String query = "SELECT * FROM AvailableRoomsPerArea";
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/e_hotels", "user", "password");
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String area = rs.getString("Area");
                int availableRooms = rs.getInt("AvailableRooms");
                AvailableRoom availableRoom = new AvailableRoom(area, availableRooms);
                availableRoomsList.add(availableRoom);
            }
            request.setAttribute("availableRoomsList", availableRoomsList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("availableRoomsPerArea.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Error handling
        }
    }
}
