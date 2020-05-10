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
        String floorstr = request.getParameter("floor");
        String shelfstr = request.getParameter("shelf");
        String areastr = request.getParameter("area");

        int result;

        if (name.length() == 0 && author.length() == 0 && category.length() == 0 &&
                pricestr.length() == 0 && floorstr.length() == 0 &&
                shelfstr.length() == 0 && areastr.length() == 0)
            result = 0;

        else {
            Double price = null;
            Integer floor = null;
            Integer shelf = null;
            Integer area = null;
            if (pricestr.length()!=0)
                price = Double.parseDouble(pricestr);
            if (floorstr.length()!=0)
                floor = Integer.parseInt(floorstr);
            if (shelfstr.length()!=0)
                shelf = Integer.parseInt(shelfstr);
            if (areastr.length()!=0)
                area = Integer.parseInt(areastr);

            result = BookService.editByIsbn(isbn,name,author,category,price,floor,shelf,area);
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("/Auth/editBookRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
