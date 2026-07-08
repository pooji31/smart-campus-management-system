package com.scms.controller;

import java.io.IOException;

import com.scms.model.Role;
import com.scms.model.User;
import com.scms.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        String password = request.getParameter("password");

        String email = request.getParameter("email");

        int roleId =
                Integer.parseInt(
                        request.getParameter("roleId"));

        Role role = new Role();

        role.setRoleId(roleId);

        User user = new User();

        user.setUsername(username);

        user.setPassword(password);

        user.setEmail(email);

        user.setRole(role);

        try {

            boolean status =
                    service.register(user);

            if(status){

                response.sendRedirect("success.jsp");

            }

            else{

                response.sendRedirect("error.jsp");

            }

        }

        catch(Exception e){

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "register.jsp")
                    .forward(request,response);

        }

    }

}