package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher(
//                "/WEB-INF/home/home.jsp");
//        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        System.out.println(password);
        User user = new UserService().readUserByEmailAndPassword(email, password);
        if (user != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/home/home.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/demo_war_exploded");
        }

    }

    public void destroy() {
    }

}
