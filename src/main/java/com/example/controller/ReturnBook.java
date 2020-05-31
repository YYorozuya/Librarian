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
        int id = Integer.parseInt(request.getParameter("id"));
        int result = BusinessService.reTurn(id);
        String resultWords;
        switch (result) {
            case 0: resultWords = "No such book to return."; break;
            case 1: resultWords = "Succeed."; break;
            case 2: resultWords = "The book is overdue. Need to pay a fine."; break;
            default: resultWords = "Error.";
        }


        request.setAttribute("result", resultWords);
        request.getRequestDispatcher("/business/returnRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
