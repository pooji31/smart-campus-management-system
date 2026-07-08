package com.scms.controller;

import java.io.IOException;

import com.scms.model.User;
import com.scms.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService service =
            new UserService();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        try {

            User user =
                    service.authenticate(
                            username,
                            password);

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "loggedInUser",
                    user);

            String roleName = user.getRole().getRoleName();

            if ("ADMIN".equals(roleName)) {

                response.sendRedirect("admin/dashboard.jsp");

            } else if ("FACULTY".equals(roleName)) {

                response.sendRedirect("faculty/dashboard.jsp");

            } else {

                response.sendRedirect("student/dashboard.jsp");

            }

        }

        catch(Exception e){

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "login.jsp")
                    .forward(request,response);

        }

    }

}