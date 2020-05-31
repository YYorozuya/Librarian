package com.example.controller;

import com.example.service.BookService;
import com.example.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delreader")
public class DelReader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String rid = request.getParameter("id");
        int result = ReaderService.delete(rid);
        String resultWords;
        switch (result) {
            case 1: resultWords = "Succeed."; break;
            case -1: resultWords = "The reader has books to be returned or has fine to be paid."; break;
            case 0: resultWords = "No such reader."; break;
            default: resultWords = "Error.";
        }
        request.setAttribute("result", resultWords);
        request.getRequestDispatcher("/reader/delReaderRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
