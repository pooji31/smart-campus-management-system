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

@WebFilter(urlPatterns = {
        "/admin/*",
        "/faculty/*",
        "/student/*"
})
public class RoleAuthorizationFilter implements Filter {

    @Override
    public void doFilter(
            jakarta.servlet.ServletRequest request,
            jakarta.servlet.ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        if (session == null) {

            res.sendRedirect(req.getContextPath() + "/login.jsp");

            return;

        }

        User user =
                (User) session.getAttribute("loggedInUser");

        if (user == null) {

            res.sendRedirect(req.getContextPath() + "/login.jsp");

            return;

        }

        String role =
                user.getRole().getRoleName();

        String uri =
                req.getRequestURI();

        if (uri.contains("/admin/")
                && !"ADMIN".equals(role)) {

            res.sendRedirect(req.getContextPath()
                    + "/accessDenied.jsp");

            return;

        }

        if (uri.contains("/faculty/")
                && !"FACULTY".equals(role)) {

            res.sendRedirect(req.getContextPath()
                    + "/accessDenied.jsp");

            return;

        }

        if (uri.contains("/student/")
                && !"STUDENT".equals(role)) {

            res.sendRedirect(req.getContextPath()
                    + "/accessDenied.jsp");

            return;

        }

        chain.doFilter(request, response);

    }

}