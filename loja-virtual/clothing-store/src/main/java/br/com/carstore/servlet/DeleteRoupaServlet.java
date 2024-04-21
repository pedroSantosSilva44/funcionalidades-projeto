package br.com.carstore.servlet;

import br.com.carstore.dao.RoupaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-car")
public class DeleteRoupaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String roupaId = req.getParameter("id");

        RoupaDAO roupaDAO = new RoupaDAO();

        roupaDAO.deleteRoupaById(roupaId);

        resp.sendRedirect("/find-all-roupas");

    }

}
