package br.com.clothingstore.servlet;

import br.com.clothingstore.dao.UserDao;
import br.com.clothingstore.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-clientes")
public class CadastroClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String nomeCliente = request.getParameter("nomeCliente");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senhaCliente");

        User user = new User();
        user.setNomeCliente(nomeCliente);
        user.setDataDeNascimento(dataDeNascimento);
        user.setEmail(email);
        user.setTelefone(telefone);
        user.setSenha(senha);

        UserDao confirmar = new UserDao();

        if (confirmar.verificarEmailExistente(email)) {
            System.out.println("O email já foi cadastrado!");
            request.getRequestDispatcher("Login.html").forward(request, resp);
        }else{
            UserDao clothingDAO = new UserDao();
            clothingDAO.cadastrarCliente(user);

            request.getRequestDispatcher("Login.html").forward(request, resp);
        }



    }

}
