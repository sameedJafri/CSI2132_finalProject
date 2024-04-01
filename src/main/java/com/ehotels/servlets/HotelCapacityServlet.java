package com.ehotels.servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ehotels.model.HotelCapacity;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelCapacityServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HotelCapacity> hotelCapacityList = new ArrayList<>();
        String query = "SELECT * FROM HotelCapacity";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_hotels", "user", "password");
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String hotelName = rs.getString("HotelName");
                int totalCapacity = rs.getInt("TotalCapacity");
                HotelCapacity hotelCapacity = new HotelCapacity(hotelName, totalCapacity);
                hotelCapacityList.add(hotelCapacity);
            }
            request.setAttribute("hotelCapacityList", hotelCapacityList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("hotelCapacity.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Error handling
        }
    }
}
