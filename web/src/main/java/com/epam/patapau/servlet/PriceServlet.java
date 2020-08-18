package com.epam.patapau.servlet;

import com.epam.patapau.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PriceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] items = request.getParameterValues("items-selector");
        ItemService itemService = new ItemService();
        if (items != null) {
            request.setAttribute("sum", itemService.countSum(items));
            request.setAttribute("selectedItems", itemService.getSelectedItems(items));
        }
        request.getRequestDispatcher("/jsp/price.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

}
