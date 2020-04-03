package com.example.controller;

import com.example.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addbook")
public class AddBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int shelf = Integer.parseInt(request.getParameter("shelf"));
        int area = Integer.parseInt(request.getParameter("area"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        int added = BookService.add(isbn,name,author,category,price,floor,shelf,area,amount);

        request.setAttribute("num",added);

        request.getRequestDispatcher("/librarian/addReturn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
