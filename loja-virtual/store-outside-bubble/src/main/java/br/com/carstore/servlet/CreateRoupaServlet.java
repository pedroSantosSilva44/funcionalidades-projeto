package br.com.carstore.servlet;

import br.com.carstore.dao.RoupaDAO;
import br.com.carstore.model.Roupa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateRoupaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carName = req.getParameter("carName");

        RoupaDAO carDAO = new RoupaDAO();

        Roupa car = new Roupa(carName);

        carDAO.createCar(car);

        resp.sendRedirect("/find-all-cars");

    }

}
