package br.com.carstore.servlet;

import br.com.carstore.dao.RoupaDAO;
import br.com.carstore.model.Roupa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-roupa")
public class CreateRoupaServlet extends HttpServlet {

    private String roupaName;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carName = req.getParameter("carName");

        RoupaDAO carDAO = new RoupaDAO();

        Roupa roupa = new Roupa(roupaName);

        carDAO.createRoupa(roupa);

        resp.sendRedirect("/find-all-roupas");

    }

}
