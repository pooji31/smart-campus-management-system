package com.scms.filter;

import java.io.IOException;

import com.scms.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/dashboard.jsp")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request,
                         jakarta.servlet.ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        if (session != null) {

            User user =
                    (User) session.getAttribute("loggedInUser");

            if (user != null) {

                chain.doFilter(request, response);

                return;

            }

        }

        res.sendRedirect("login.jsp");

    }

}