package br.com.clothingstore.dao;

import br.com.clothingstore.model.User;

import br.com.clothingstore.config.ConnectionPoolConfig;

import java.sql.*;

public class UserDao {

    public boolean verifyCredentials(User user) {
        String SQL = "SELECT * FROM USR WHERE USERNAME = ?";
        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("success in select username");
            while (resultSet.next()) {
                String password = resultSet.getString("password");
                if (password.equals(user.getSenha())) {
                    return true;
                }
            }
            connection.close();
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean verificarEmailExistente(String email) {
        String SQL = "SELECT * FROM CLIENTE WHERE EMAIL = ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next()) {
                int count = resultado.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            System.out.println("Erro ao verificar email existente no banco!");
        }
        return false;
    }

    public void cadastrarCliente(User user) {
        String SQL = "INSERT INTO CLIENTE (NOME, EMAIL, DATANASCIMENTO, SENHA) VALUES (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getNomeCliente());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getDataDeNascimento());
            preparedStatement.setString(4, user.getSenha());
            preparedStatement.execute();
            System.out.println("Sucesso ao gravar cliente no banco!");
        } catch (Exception e) {
            System.out.println("Erro ao gravar cliente no banco!");
        }
    }
}
