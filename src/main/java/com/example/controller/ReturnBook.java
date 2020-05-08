package com.example.controller;

import com.example.service.BookService;
import com.example.service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/returnbook")
public class ReturnBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idstr = request.getParameter("id");
        int id = -1;
        if (idstr.length() != 0)
            id = Integer.parseInt(idstr);
        int result = BusinessService.reTurn(id);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/Auth/returnRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
