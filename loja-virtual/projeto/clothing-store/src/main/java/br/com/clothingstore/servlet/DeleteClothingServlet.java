package br.com.clothingstore.servlet;


import br.com.clothingstore.dao.ClothingDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-clothing")
public class DeleteClothingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clothingId = req.getParameter("id");
        new ClothingDAO().deleteClothingById(clothingId);
        resp.sendRedirect("/find-all-clothings");


    }
}
