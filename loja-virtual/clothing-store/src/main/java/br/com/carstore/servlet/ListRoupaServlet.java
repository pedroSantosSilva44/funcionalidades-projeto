package br.com.carstore.servlet;

import br.com.carstore.dao.RoupaDAO;
import br.com.carstore.model.Roupa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-cars")
public class ListRoupaServlet extends HttpServlet {

    private RoupaDAO roupaDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RoupaDAO carDAO = new RoupaDAO();

        List<Roupa> allRoupas = roupaDAO.findAllRoupas();

        req.setAttribute("roupas", allRoupas);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}
