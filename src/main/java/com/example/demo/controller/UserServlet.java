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
import java.util.List;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("list")) {
            UserService userService = new UserService();
            List<User> userList = userService.readUsers();
            request.setAttribute("userList", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/user/list.jsp");
            dispatcher.forward(request, response);
        } else if (page.equalsIgnoreCase("add")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/user/add.jsp");
            dispatcher.forward(request, response);
        } else if (page.equalsIgnoreCase("edit")) {
            UserService userService = new UserService();
            Long id = Long.parseLong(request.getParameter("id"));
            User user = userService.readUserById(id);
            request.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    "/WEB-INF/user/add.jsp");
            dispatcher.forward(request, response);
        } else if (page.equalsIgnoreCase("delete")) {
            Long id = Long.parseLong(request.getParameter("id"));
            UserService userService = new UserService();
            userService.deleteUserById(id);
            response.sendRedirect("/demo_war_exploded/user?page=list");
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page = request.getParameter("page");
        UserService userService = new UserService();
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if (page.equalsIgnoreCase("update")) {
            Long id = Long.parseLong(request.getParameter("id"));
            user.setId(id);
            userService.updateUser(user);
        } else
            userService.insertUser(user);

        response.sendRedirect("/demo_war_exploded/user?page=list");
    }

    public void destroy() {
    }
}
