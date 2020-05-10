package com.example.controller;

import com.example.service.BookService;
import com.example.service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/payfine")
public class PayFine extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        int result = BusinessService.payFine(id);
        String resultWords;
        switch (result) {
            case 0: resultWords = "No such record of fine to pay."; break;
            case 1: resultWords = "Succeed."; break;
            default: resultWords = "Error.";
        }


        request.setAttribute("result", resultWords);
        request.getRequestDispatcher("/Auth/payRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
