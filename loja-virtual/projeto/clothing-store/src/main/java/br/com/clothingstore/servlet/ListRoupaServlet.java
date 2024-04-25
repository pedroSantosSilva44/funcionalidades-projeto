package br.com.clothingstore.servlet;


import br.com.clothingstore.dao.RoupaDAO;
import br.com.clothingstore.model.Roupa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-cars")
public class ListRoupaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RoupaDAO carDAO = new RoupaDAO();


        req.setAttribute("cars", allCars);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}
