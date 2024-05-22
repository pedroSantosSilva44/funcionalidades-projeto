package br.com.clothingstore.servlet;

import javax.servlet.annotation.WebServlet;
import br.com.clothingstore.dao.ClothingDAO;
import br.com.clothingstore.model.Clothing;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-clothing")
public class UpdateClothingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String clothingId = req.getParameter("clothing-id");
        String clothingName = req.getParameter("clothing-name");
        String clothingImage = req.getParameter("image");

        if (clothingId != null && !clothingId.isEmpty() && clothingName != null && !clothingName.isEmpty() && clothingImage != null && !clothingImage.isEmpty()) {
            try {

                clothingId = String.valueOf(Integer.parseInt(clothingId));


                Clothing updatedClothing = new Clothing(clothingId, clothingName, clothingImage);


                ClothingDAO clothingDAO = new ClothingDAO();


                clothingDAO.updateClothing(updatedClothing);


                resp.sendRedirect("/find-all-clothings");
            } catch (NumberFormatException e) {

                e.printStackTrace(); // Apenas para fins de depuração, você pode tratar de forma mais apropriada
                resp.sendRedirect("/error-page"); // Página de erro padrão
            }
        } else {

            resp.sendRedirect("/error-page"); // Página de erro padrão
        }
    }
}