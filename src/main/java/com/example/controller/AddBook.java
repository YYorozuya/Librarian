package com.example.controller;

import com.example.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/addbook")
public class AddBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        String pricestr = request.getParameter("price");
        String floorstr = request.getParameter("floor");
        String shelfstr = request.getParameter("shelf");
        String areastr = request.getParameter("area");
        String amountstr = request.getParameter("amount");
        double price = Double.parseDouble(pricestr);
        int floor = Integer.parseInt(floorstr);
        int shelf = Integer.parseInt(shelfstr);
        int area = Integer.parseInt(areastr);
        int amount = Integer.parseInt(amountstr);
        int added = BookService.add(isbn,name,author,category,price,floor,shelf,area,amount);

        request.setAttribute("addedNum",added);

        request.getRequestDispatcher("/Auth/addBookRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
