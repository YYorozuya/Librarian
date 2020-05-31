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
        String resultWords;
        switch (result) {
            case 1: resultWords = "Succeed."; break;
            case 0: resultWords = "No such book or reader."; break;
            case -1: resultWords = "The book has been reserved."; break;
            case -2: resultWords = "The reader has already borrowed 3 books."; break;
            case -3: resultWords = "The book has been lent."; break;
            default: resultWords = "Error.";
        }

        request.setAttribute("result",resultWords);
        request.getRequestDispatcher("/business/lendRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
