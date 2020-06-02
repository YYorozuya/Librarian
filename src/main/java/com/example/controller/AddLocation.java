package com.example.controller;

import com.example.service.ReaderService;
import com.example.service.Settings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addlocation")
public class AddLocation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String floor = request.getParameter("floor");
        String shelf = request.getParameter("shelf");
        String area = request.getParameter("area");

        String location = floor+"-"+shelf+"-"+area;
        int result = Settings.addLocation(location);

        request.getRequestDispatcher("/book/bookSettings.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
