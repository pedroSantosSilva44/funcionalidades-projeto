package br.com.clothingstore.servlet;

import br.com.clothingstore.dao.ClothingDAO;
import br.com.clothingstore.model.Clothing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-clothings")
public class ListClothingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Clothing> clothings = new ClothingDAO().findAllClothings();

        req.setAttribute("clothings", clothings);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}

