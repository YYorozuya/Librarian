package com.example.controller;

import com.example.service.ReaderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editreader")
public class EditReader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        String email = request.getParameter("email");

        int result;
        if (name.length()==0 && passwd.length()==0 && email.length()==0)
            result = 0;
        else
            result = ReaderService.edit(id,name,passwd,email);


        request.setAttribute("result", result);
        request.getRequestDispatcher("/Auth/editReaderReturn.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
