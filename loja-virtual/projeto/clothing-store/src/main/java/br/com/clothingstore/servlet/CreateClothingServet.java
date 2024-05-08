package br.com.clothingstore.servlet;

import br.com.clothingstore.dao.ClothingDAO;
import br.com.clothingstore.model.Clothing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-clothing")
public class CreateClothingServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String clothingName = req.getParameter("clothing-name");

        ClothingDAO clothingDAO = new ClothingDAO();

        clothingDAO.createClothing(new Clothing(clothingName));

        resp.sendRedirect("/find-all-clothings");


    }
}
