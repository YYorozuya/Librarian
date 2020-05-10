package com.example.controller;

import com.example.service.BookService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delbook")
public class DelBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bkid = request.getParameter("id");
        String libid = (String) request.getSession().getAttribute("LibrarianID");
        int result = BookService.delete(bkid,libid);
        String resultWords;
        if (result == 1)
            resultWords = "Succeed.";
        else
            resultWords = "The book was lent. Delete it after it is returned.";
        request.setAttribute("result", resultWords);
        request.getRequestDispatcher("/Auth/delBookRtn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
