package com.epam.patapau.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.epam.patapau.service.ItemService;

import static com.epam.patapau.service.ItemService.getItems;

public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("name").isEmpty()) {
            doGet(request, response);
        } else {
            request.setAttribute("items", getItems());
            request.getRequestDispatcher("/jsp/order.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }


}
