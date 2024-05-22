package br.com.clothingstore.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Obtém a sessão, não cria uma nova se não existir

        if (session != null) {
            session.invalidate(); // Invalida a sessão existente, removendo quaisquer atributos associados a ela
        }

        // Redireciona para a página de login
        response.sendRedirect(request.getContextPath() + "/login.html");
    }
}