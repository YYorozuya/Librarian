package com.example.controller;

import com.example.service.BookService;
import com.example.service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lendbook")
public class LendBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bkid = request.getParameter("book");
        String readerid = request.getParameter("reader");
        int result = BusinessService.lend(bkid,readerid);
        request.setAttribute("result",result);
        request.getRequestDispatcher("/Auth/lendReturn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
