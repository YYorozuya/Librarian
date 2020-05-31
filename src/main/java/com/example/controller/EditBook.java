package com.example.controller;

import com.example.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editbook")
public class EditBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String isbn = request.getParameter("isbn");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        String pricestr = request.getParameter("price");
        String location = request.getParameter("location");

        int result;

        if (name.length() == 0 && author.length() == 0 && category.length() == 0 &&
                pricestr.length() == 0 && location.length()==0)
            result = 0;

        else {
            Double price = null;
            if (pricestr.length()!=0)
                price = Double.parseDouble(pricestr);

            result = BookService.editByIsbn(isbn,name,author,category,price,location);
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("/book/editBookRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
