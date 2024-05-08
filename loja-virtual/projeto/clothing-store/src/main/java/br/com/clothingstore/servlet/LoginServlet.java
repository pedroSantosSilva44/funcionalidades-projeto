package br.com.clothingstore.servlet;


import br.com.clothingstore.dao.UserDao;
import br.com.clothingstore.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/index.html").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username, password);

        boolean isValidUser = new UserDao().verifyCredentials(user);

        if (isValidUser) {

            req.setAttribute("loggedUser", username);

            req.getRequestDispatcher("/admin.html").forward(req, resp);

        } else {

            req.setAttribute("message", "Invalid credentials!");

            req.getRequestDispatcher("/index.html").forward(req, resp);

        }

    }

}